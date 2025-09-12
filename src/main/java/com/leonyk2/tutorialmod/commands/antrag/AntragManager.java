package com.leonyk2.tutorialmod.commands.antrag;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.*;

public class AntragManager {

    public enum Status {
        NONE,
        ACCEPTED,
        DENIED
    }

    public static class Antrag {
        public final int id;
        public final UUID author;
        public final String text;
        public Status status;

        public Antrag(int id, UUID author, String text) {
            this.id = id;
            this.author = author;
            this.text = text;
            this.status = Status.NONE;
        }
    }

    private static final Map<Integer, Antrag> ANTRAEGE = new HashMap<>();
    private static final TreeSet<Integer> FREE_IDS = new TreeSet<>();
    private static int NEXT_ID = 0;

    public static void createAntrag(ServerPlayer player, String text) {
        int id = createAntragFor(player, text);

        player.sendSystemMessage(Component.literal(
                "Your Antrag (ID: " + id + ") was submitted"
        ));
    }
    public static int createAntragFor(ServerPlayer target, String text) {
        int id = getNextId();
        Antrag antrag = new Antrag(id, target.getUUID(), text);
        ANTRAEGE.put(id, antrag);

        return id;
    }

    public static int createAntragForCustom(String username, String text) {
        int id = getNextId();
        // Use null UUID but store the username in a map
        Antrag antrag = new Antrag(id, null, text);
        customAuthors.put(id, username); // store mapping of id -> username
        ANTRAEGE.put(id, antrag);
        return id;
    }

    private static final Map<Integer, String> customAuthors = new HashMap<>();



    public static boolean deleteAntrag(ServerPlayer requester, int id) {
        Antrag antrag = ANTRAEGE.get(id);
        if (antrag == null) return false;

        boolean isOp = requester.hasPermissions(2);
        boolean isAuthor = antrag.author.equals(requester.getUUID());

        if (isAuthor || isOp) {
            ANTRAEGE.remove(id);
            FREE_IDS.add(id);
            return true;
        }
        return false;
    }

    public static boolean setStatus(int id, Status status) {
        Antrag antrag = ANTRAEGE.get(id);
        if (antrag == null) return false;
        antrag.status = status;
        return true;
    }

    public static List<Antrag> listAll() {
        return new ArrayList<>(ANTRAEGE.values());
    }

    public static List<Antrag> listByPlayer(ServerPlayer player) {
        List<Antrag> result = new ArrayList<>();
        for (Antrag a : ANTRAEGE.values()) {
            if (a.author != null && a.author.equals(player.getUUID())) {
                result.add(a);
            }
        }
        return result;
    }

    private static int getNextId() {
        if (!FREE_IDS.isEmpty()) {
            return FREE_IDS.pollFirst();
        }
        return NEXT_ID++;
    }

    public static String getCustomAuthorName(int id) {
        return customAuthors.getOrDefault(id, "Offline/Unknown");
    }
}
