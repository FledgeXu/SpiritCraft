package com.otakusaikou.spritcraft.spirit;

public class SpiritCal {
    public static void add(Spirit a, Spirit b) {
        a.setMetal(a.getMetal() + b.getMetal());
        a.setWooden(a.getWooden() + b.getWooden());
        a.setWater(a.getWater() + b.getWater());
        a.setFire(a.getFire() + a.getFire());
        a.setEarth(a.getEarth() + a.getEarth());
    }

    public static void sub(Spirit a, Spirit b) {
        a.setMetal(subOreGetZero(a.getMetal(), b.getMetal()));
        a.setWooden(subOreGetZero(a.getWooden(), b.getWooden()));
        a.setWater(subOreGetZero(a.getWater(), b.getWater()));
        a.setFire(subOreGetZero(a.getFire(), b.getFire()));
        a.setEarth(subOreGetZero(a.getEarth(), b.getEarth()));
    }

    private static int subOreGetZero(int a, int b) {
        return Math.max((a - b), 0);
    }

    public static float[] division(Spirit a, Spirit b) {
        return new float[]{a.getMetal() / (float) b.getMetal(), a.getWooden() / (float) b.getWooden(), a.getWater() / (float) b.getWater(), a.getFire() / (float) b.getFire(), a.getEarth() / (float) b.getEarth()};
    }
}
