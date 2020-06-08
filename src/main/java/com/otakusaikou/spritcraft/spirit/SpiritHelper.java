package com.otakusaikou.spritcraft.spirit;

public class SpiritHelper {
    public static void addWithLimit(Spirit a, Spirit b, Spirit c) {
        a.metal = addWithLimit(a.metal, b.metal, c.metal);
        a.wooden = addWithLimit(a.wooden, b.wooden, c.wooden);
        a.water = addWithLimit(a.water, b.water, c.water);
        a.fire = addWithLimit(a.fire, b.fire, c.fire);
        a.earth = addWithLimit(a.earth, b.earth, c.earth);
    }

    private static int addWithLimit(int a, int b, int c) {
        return Math.min((a + b), c);
    }

    public static boolean sub(Spirit a, Spirit b) {
        if (a.metal < b.metal || a.wooden < b.wooden || a.water < b.water || a.fire < b.fire || a.earth < b.earth) {
            return false;
        }
        a.metal = subOreGetZero(a.metal, b.metal);
        a.wooden = subOreGetZero(a.wooden, b.wooden);
        a.water = subOreGetZero(a.water, b.water);
        a.fire = subOreGetZero(a.fire, b.fire);
        a.earth = subOreGetZero(a.earth, b.earth);
        return true;
    }

    private static int subOreGetZero(int a, int b) {
        return Math.max((a - b), 0);
    }

    public static float[] division(Spirit a, Spirit b) {
        return new float[]{a.metal / (float) b.metal, a.wooden / (float) b.wooden, a.water / (float) b.water, a.fire / (float) b.fire, a.earth / (float) b.earth};
    }

    public static int getValueFromType(Spirit spirit, SpiritType type) {
        switch (type) {
            case metal:
                return spirit.metal;
            case wooden:
                return spirit.wooden;
            case water:
                return spirit.water;
            case fire:
                return spirit.fire;
            case earth:
                return spirit.earth;
        }
        return 0;
    }

    public static void putValueBaseOnType(Spirit spirit, SpiritType type, int val) {
        switch (type) {
            case metal:
                spirit.metal = val;
                break;
            case wooden:
                spirit.wooden = val;
                break;
            case water:
                spirit.water = val;
                break;
            case fire:
                spirit.fire = val;
                break;
            case earth:
                spirit.earth = val;
                break;
        }
    }
}
