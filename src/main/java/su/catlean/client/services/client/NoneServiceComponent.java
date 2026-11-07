package su.catlean.client.services.client;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import su.catlean.client.features.modules.Module;

public class NoneServiceComponent {

    public static final NoneServiceComponent INSTANCE;
    private static final Map lookupMap;
    private static Module[] moduleArray;

    private NoneServiceComponent() {
    }

    public String resolveString(int key) {
        if (((String) lookupMap.get(Integer.valueOf(key))) == null) {
        }
        return "None";
    }

    static {
        INSTANCE = new NoneServiceComponent();
        Pair[] items = new Pair[123];
        items[0] = TuplesKt.to(Integer.valueOf(0), "LMB");
        items[1] = TuplesKt.to(Integer.valueOf(1), "RMB");
        items[2] = TuplesKt.to(Integer.valueOf(2), "MMB");
        items[3] = TuplesKt.to(Integer.valueOf(3), "Mouse 4");
        items[4] = TuplesKt.to(Integer.valueOf(4), "Mouse 5");
        items[5] = TuplesKt.to(Integer.valueOf(32), "Space");
        items[6] = TuplesKt.to(Integer.valueOf(39), "Apostrophe");
        items[7] = TuplesKt.to(Integer.valueOf(44), "Comma");
        items[8] = TuplesKt.to(Integer.valueOf(45), "Minus");
        items[9] = TuplesKt.to(Integer.valueOf(46), "Period");
        items[10] = TuplesKt.to(Integer.valueOf(47), "Slash");
        items[11] = TuplesKt.to(Integer.valueOf(48), "0");
        items[12] = TuplesKt.to(Integer.valueOf(49), "1");
        items[13] = TuplesKt.to(Integer.valueOf(50), "2");
        items[14] = TuplesKt.to(Integer.valueOf(51), "3");
        items[15] = TuplesKt.to(Integer.valueOf(52), "4");
        items[16] = TuplesKt.to(Integer.valueOf(53), "5");
        items[17] = TuplesKt.to(Integer.valueOf(54), "6");
        items[18] = TuplesKt.to(Integer.valueOf(55), "7");
        items[19] = TuplesKt.to(Integer.valueOf(56), "8");
        items[20] = TuplesKt.to(Integer.valueOf(57), "9");
        items[21] = TuplesKt.to(Integer.valueOf(59), "SemiColon");
        items[22] = TuplesKt.to(Integer.valueOf(61), "Equal");
        items[23] = TuplesKt.to(Integer.valueOf(65), "A");
        items[24] = TuplesKt.to(Integer.valueOf(66), "B");
        items[25] = TuplesKt.to(Integer.valueOf(67), "C");
        items[26] = TuplesKt.to(Integer.valueOf(68), "D");
        items[27] = TuplesKt.to(Integer.valueOf(69), "E");
        items[28] = TuplesKt.to(Integer.valueOf(70), "F");
        items[29] = TuplesKt.to(Integer.valueOf(71), "G");
        items[30] = TuplesKt.to(Integer.valueOf(72), "H");
        items[31] = TuplesKt.to(Integer.valueOf(73), "I");
        items[32] = TuplesKt.to(Integer.valueOf(74), "J");
        items[33] = TuplesKt.to(Integer.valueOf(75), "K");
        items[34] = TuplesKt.to(Integer.valueOf(76), "L");
        items[35] = TuplesKt.to(Integer.valueOf(77), "M");
        items[36] = TuplesKt.to(Integer.valueOf(78), "N");
        items[37] = TuplesKt.to(Integer.valueOf(79), "O");
        items[38] = TuplesKt.to(Integer.valueOf(80), "P");
        items[39] = TuplesKt.to(Integer.valueOf(81), "Q");
        items[40] = TuplesKt.to(Integer.valueOf(82), "R");
        items[41] = TuplesKt.to(Integer.valueOf(83), "S");
        items[42] = TuplesKt.to(Integer.valueOf(84), "T");
        items[43] = TuplesKt.to(Integer.valueOf(85), "U");
        items[44] = TuplesKt.to(Integer.valueOf(86), "V");
        items[45] = TuplesKt.to(Integer.valueOf(87), "W");
        items[46] = TuplesKt.to(Integer.valueOf(88), "X");
        items[47] = TuplesKt.to(Integer.valueOf(89), "Y");
        items[48] = TuplesKt.to(Integer.valueOf(90), "Z");
        items[49] = TuplesKt.to(Integer.valueOf(91), "LeftBracket");
        items[50] = TuplesKt.to(Integer.valueOf(92), "BackSlash");
        items[51] = TuplesKt.to(Integer.valueOf(93), "RightBracket");
        items[52] = TuplesKt.to(Integer.valueOf(96), "Grave");
        items[53] = TuplesKt.to(Integer.valueOf(256), "Escape");
        items[54] = TuplesKt.to(Integer.valueOf(257), "Enter");
        items[55] = TuplesKt.to(Integer.valueOf(258), "Tab");
        items[56] = TuplesKt.to(Integer.valueOf(259), "BackSpace");
        items[57] = TuplesKt.to(Integer.valueOf(260), "Insert");
        items[58] = TuplesKt.to(Integer.valueOf(261), "Delete");
        items[59] = TuplesKt.to(Integer.valueOf(262), "Right");
        items[60] = TuplesKt.to(Integer.valueOf(263), "Left");
        items[61] = TuplesKt.to(Integer.valueOf(264), "Down");
        items[62] = TuplesKt.to(Integer.valueOf(265), "Up");
        items[63] = TuplesKt.to(Integer.valueOf(266), "PageUp");
        items[64] = TuplesKt.to(Integer.valueOf(267), "PageDown");
        items[65] = TuplesKt.to(Integer.valueOf(268), "Home");
        items[66] = TuplesKt.to(Integer.valueOf(269), "End");
        items[67] = TuplesKt.to(Integer.valueOf(280), "CapsLock");
        items[68] = TuplesKt.to(Integer.valueOf(281), "ScrollLock");
        items[69] = TuplesKt.to(Integer.valueOf(282), "NumLock");
        items[70] = TuplesKt.to(Integer.valueOf(283), "PrintScreen");
        items[71] = TuplesKt.to(Integer.valueOf(284), "Pause");
        items[72] = TuplesKt.to(Integer.valueOf(290), "F1");
        items[73] = TuplesKt.to(Integer.valueOf(291), "F2");
        items[74] = TuplesKt.to(Integer.valueOf(292), "F3");
        items[75] = TuplesKt.to(Integer.valueOf(293), "F4");
        items[76] = TuplesKt.to(Integer.valueOf(294), "F5");
        items[77] = TuplesKt.to(Integer.valueOf(295), "F6");
        items[78] = TuplesKt.to(Integer.valueOf(296), "F7");
        items[79] = TuplesKt.to(Integer.valueOf(297), "F8");
        items[80] = TuplesKt.to(Integer.valueOf(298), "F9");
        items[81] = TuplesKt.to(Integer.valueOf(299), "F10");
        items[82] = TuplesKt.to(Integer.valueOf(300), "F11");
        items[83] = TuplesKt.to(Integer.valueOf(301), "F12");
        items[84] = TuplesKt.to(Integer.valueOf(302), "F13");
        items[85] = TuplesKt.to(Integer.valueOf(303), "F14");
        items[86] = TuplesKt.to(Integer.valueOf(304), "F15");
        items[87] = TuplesKt.to(Integer.valueOf(305), "F16");
        items[88] = TuplesKt.to(Integer.valueOf(306), "F17");
        items[89] = TuplesKt.to(Integer.valueOf(307), "F18");
        items[90] = TuplesKt.to(Integer.valueOf(308), "F19");
        items[91] = TuplesKt.to(Integer.valueOf(309), "F20");
        items[92] = TuplesKt.to(Integer.valueOf(310), "F21");
        items[93] = TuplesKt.to(Integer.valueOf(311), "F22");
        items[94] = TuplesKt.to(Integer.valueOf(312), "F23");
        items[95] = TuplesKt.to(Integer.valueOf(313), "F24");
        items[96] = TuplesKt.to(Integer.valueOf(314), "F25");
        items[97] = TuplesKt.to(Integer.valueOf(320), "NUM 0");
        items[98] = TuplesKt.to(Integer.valueOf(321), "NUM 1");
        items[99] = TuplesKt.to(Integer.valueOf(322), "NUM 2");
        items[100] = TuplesKt.to(Integer.valueOf(323), "NUM 3");
        items[101] = TuplesKt.to(Integer.valueOf(324), "NUM 4");
        items[102] = TuplesKt.to(Integer.valueOf(325), "NUM 5");
        items[103] = TuplesKt.to(Integer.valueOf(326), "NUM 6");
        items[104] = TuplesKt.to(Integer.valueOf(327), "NUM 7");
        items[105] = TuplesKt.to(Integer.valueOf(328), "NUM 8");
        items[106] = TuplesKt.to(Integer.valueOf(329), "NUM 9");
        items[107] = TuplesKt.to(Integer.valueOf(330), "Deci");
        items[108] = TuplesKt.to(Integer.valueOf(331), "Div");
        items[109] = TuplesKt.to(Integer.valueOf(332), "Mul");
        items[110] = TuplesKt.to(Integer.valueOf(333), "Sub");
        items[111] = TuplesKt.to(Integer.valueOf(334), "Add");
        items[112] = TuplesKt.to(Integer.valueOf(335), "Enter");
        items[113] = TuplesKt.to(Integer.valueOf(336), "Equal");
        items[114] = TuplesKt.to(Integer.valueOf(340), "Shift");
        items[115] = TuplesKt.to(Integer.valueOf(341), "LCtrl");
        items[116] = TuplesKt.to(Integer.valueOf(342), "LAlt");
        items[117] = TuplesKt.to(Integer.valueOf(343), "LSuper");
        items[118] = TuplesKt.to(Integer.valueOf(344), "RShift");
        items[119] = TuplesKt.to(Integer.valueOf(345), "RCtrl");
        items[120] = TuplesKt.to(Integer.valueOf(346), "RAlt");
        items[121] = TuplesKt.to(Integer.valueOf(347), "RSuper");
        items[122] = TuplesKt.to(Integer.valueOf(348), "Menu");
        lookupMap = MapsKt.mapOf(items);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
