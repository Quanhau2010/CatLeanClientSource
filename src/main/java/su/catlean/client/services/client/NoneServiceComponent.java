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
        if (var4 == null) {
            if ((String) lookupMap.get(Integer.valueOf(key)) == null) {
            }
        }
        return "None";
    }

    static {
        INSTANCE = new NoneServiceComponent();
        Pair[] var22 = new Pair[8445778348331761787L];
        var22[0] = TuplesKt.to(Integer.valueOf(0), "LMB");
        var22[1] = TuplesKt.to(Integer.valueOf(1), "RMB");
        var22[2] = TuplesKt.to(Integer.valueOf(2), "MMB");
        var22[3] = TuplesKt.to(Integer.valueOf(3), "Mouse 4");
        var22[4] = TuplesKt.to(Integer.valueOf(4), "Mouse 5");
        var22[5] = TuplesKt.to(Integer.valueOf(7754147575539695648L), "Space");
        var22[-1470581151289573370L] = TuplesKt.to(Integer.valueOf(-2213952140966100953L), "Apostrophe");
        var22[6679508846404173831L] = TuplesKt.to(Integer.valueOf(-1331114479332622292L), "Comma");
        var22[-1195194269246160888L] = TuplesKt.to(Integer.valueOf(5943776773891162157L), "Minus");
        var22[8332257625349554185L] = TuplesKt.to(Integer.valueOf(-8457392253432758226L), "Period");
        var22[-896268737332641782L] = TuplesKt.to(Integer.valueOf(8810099576280186927L), "Slash");
        var22[4817857556875575307L] = TuplesKt.to(Integer.valueOf(-3611939011989340112L), "0");
        var22[9090208190749999116L] = TuplesKt.to(Integer.valueOf(-4338057470225153999L), "1");
        var22[8099898335562825741L] = TuplesKt.to(Integer.valueOf(3899550990159839282L), "2");
        var22[5340435504909254670L] = TuplesKt.to(Integer.valueOf(-2711409615559458765L), "3");
        var22[-7723276338458525681L] = TuplesKt.to(Integer.valueOf(5877233574263914548L), "4");
        var22[2748945757120757776L] = TuplesKt.to(Integer.valueOf(8436524368846127157L), "5");
        var22[-8785693407440797679L] = TuplesKt.to(Integer.valueOf(-4863305036786040778L), "6");
        var22[11845738845700114L] = TuplesKt.to(Integer.valueOf(-2579726107242659785L), "7");
        var22[-1237179421400498157L] = TuplesKt.to(Integer.valueOf(6337499853299384376L), "8");
        var22[-1232131756790906860L] = TuplesKt.to(Integer.valueOf(-9182215525625757639L), "9");
        var22[7716297609308012565L] = TuplesKt.to(Integer.valueOf(-1441385569929134021L), "SemiColon");
        var22[-7691354818664726506L] = TuplesKt.to(Integer.valueOf(-8200640461392576451L), "Equal");
        var22[3964349440927465495L] = TuplesKt.to(Integer.valueOf(366715345798430785L), "A");
        var22[6354539560520646680L] = TuplesKt.to(Integer.valueOf(3654850429675634754L), "B");
        var22[7574274701665501209L] = TuplesKt.to(Integer.valueOf(-3855056112520789949L), "C");
        var22[6343729677592428570L] = TuplesKt.to(Integer.valueOf(9199309929255534660L), "D");
        var22[2462532036171137051L] = TuplesKt.to(Integer.valueOf(-5303249463312121787L), "E");
        var22[8359498309395546140L] = TuplesKt.to(Integer.valueOf(-1140874950270255034L), "F");
        var22[-2087274636076122083L] = TuplesKt.to(Integer.valueOf(-1276725152389791673L), "G");
        var22[4466945264069902366L] = TuplesKt.to(Integer.valueOf(-6035382001043767224L), "H");
        var22[-2150034338882781153L] = TuplesKt.to(Integer.valueOf(6635708593825906761L), "I");
        var22[-223238815064522720L] = TuplesKt.to(Integer.valueOf(6465028277110046794L), "J");
        var22[-7142111119497232351L] = TuplesKt.to(Integer.valueOf(4113538321114726475L), "K");
        var22[1274988280500191266L] = TuplesKt.to(Integer.valueOf(-1675628537882607540L), "L");
        var22[6712374816621461539L] = TuplesKt.to(Integer.valueOf(5609023140190486605L), "M");
        var22[-227709450817896412L] = TuplesKt.to(Integer.valueOf(-6920075419261599666L), "N");
        var22[4001297270753460261L] = TuplesKt.to(Integer.valueOf(7354334142311432271L), "O");
        var22[-970767595076583386L] = TuplesKt.to(Integer.valueOf(7252507369735716944L), "P");
        var22[2771409033079291943L] = TuplesKt.to(Integer.valueOf(-974882276825366447L), "Q");
        var22[-2781989547574034392L] = TuplesKt.to(Integer.valueOf(398583736846778450L), "R");
        var22[-5931172904598241239L] = TuplesKt.to(Integer.valueOf(129637093839208531L), "S");
        var22[5098362515222429738L] = TuplesKt.to(Integer.valueOf(-3862871535660302252L), "T");
        var22[-953455157432025045L] = TuplesKt.to(Integer.valueOf(-2847056833229619115L), "U");
        var22[8957487636809777196L] = TuplesKt.to(Integer.valueOf(3831916074270457942L), "V");
        var22[-3700173132196216787L] = TuplesKt.to(Integer.valueOf(1522529837296648279L), "W");
        var22[-1577574885486493650L] = TuplesKt.to(Integer.valueOf(-3077237135783231400L), "X");
        var22[-4343794146373271505L] = TuplesKt.to(Integer.valueOf(-5870221778160189351L), "Y");
        var22[5256319120172908592L] = TuplesKt.to(Integer.valueOf(6682127603928662106L), "Z");
        var22[-9134409533144170447L] = TuplesKt.to(Integer.valueOf(118493938628690011L), "LeftBracket");
        var22[7953195171993092146L] = TuplesKt.to(Integer.valueOf(2851801333277655132L), "BackSlash");
        var22[3677647214139670579L] = TuplesKt.to(Integer.valueOf(-9161540820078165923L), "RightBracket");
        var22[4235382467378282548L] = TuplesKt.to(Integer.valueOf(4582111977433727072L), "Grave");
        var22[7960564287901007925L] = TuplesKt.to(Integer.valueOf(-9075370023635123968L), "Escape");
        var22[277057229184565302L] = TuplesKt.to(Integer.valueOf(-2741629276037054207L), "Enter");
        var22[3441708588802768951L] = TuplesKt.to(Integer.valueOf(-8890942474382475006L), "Tab");
        var22[-874511365019008968L] = TuplesKt.to(Integer.valueOf(8816630456305844483L), "BackSpace");
        var22[2774419641945030713L] = TuplesKt.to(Integer.valueOf(8751923226348617988L), "Insert");
        var22[-166163832186601414L] = TuplesKt.to(Integer.valueOf(-8919150513912545019L), "Delete");
        var22[-2254731188994310085L] = TuplesKt.to(Integer.valueOf(-5872643164757556986L), "Right");
        var22[386733127508164668L] = TuplesKt.to(Integer.valueOf(3470342667613765895L), "Left");
        var22[6953239606238117949L] = TuplesKt.to(Integer.valueOf(-8241132365087244024L), "Down");
        var22[-1052835598240317378L] = TuplesKt.to(Integer.valueOf(-1169140430692941559L), "Up");
        var22[-8407344111928999873L] = TuplesKt.to(Integer.valueOf(490449921917321482L), "PageUp");
        var22[7847495906579447872L] = TuplesKt.to(Integer.valueOf(3844621523834896651L), "PageDown");
        var22[-4780967979691016127L] = TuplesKt.to(Integer.valueOf(3944312078461829388L), "Home");
        var22[-7077374928575528894L] = TuplesKt.to(Integer.valueOf(-5004815112448507635L), "End");
        var22[-6746929902986985405L] = TuplesKt.to(Integer.valueOf(1293044829818716440L), "CapsLock");
        var22[6662017656515723332L] = TuplesKt.to(Integer.valueOf(6751322434760081689L), "ScrollLock");
        var22[5301439804611756101L] = TuplesKt.to(Integer.valueOf(1731784672637092122L), "NumLock");
        var22[-2627972780548685754L] = TuplesKt.to(Integer.valueOf(1273394577050435867L), "PrintScreen");
        var22[-3830162293094612921L] = TuplesKt.to(Integer.valueOf(8509758994376556828L), "Pause");
        var22[-6862017709211647928L] = TuplesKt.to(Integer.valueOf(-7040898119222951646L), "F1");
        var22[-8835429906117558199L] = TuplesKt.to(Integer.valueOf(8795311196426207523L), "F2");
        var22[4200016156179824714L] = TuplesKt.to(Integer.valueOf(-9002896346050461404L), "F3");
        var22[-8838246657339424693L] = TuplesKt.to(Integer.valueOf(2999404292495900965L), "F4");
        var22[6700831868675162188L] = TuplesKt.to(Integer.valueOf(3539970877825220902L), "F5");
        var22[5960419729213489229L] = TuplesKt.to(Integer.valueOf(-7032247071541296857L), "F6");
        var22[-2315167335968669618L] = TuplesKt.to(Integer.valueOf(8568369088760381736L), "F7");
        var22[-822818628998004657L] = TuplesKt.to(Integer.valueOf(-641271787325226711L), "F8");
        var22[-4373538830712569776L] = TuplesKt.to(Integer.valueOf(-3487234761104031446L), "F9");
        var22[3315667537936515153L] = TuplesKt.to(Integer.valueOf(-5745893276783738581L), "F10");
        var22[-6164974414338195374L] = TuplesKt.to(Integer.valueOf(-374547725468827348L), "F11");
        var22[-50264822603841453L] = TuplesKt.to(Integer.valueOf(-541419892251819731L), "F12");
        var22[-5838345007630647212L] = TuplesKt.to(Integer.valueOf(-2385833210278837970L), "F13");
        var22[-7983206071290298283L] = TuplesKt.to(Integer.valueOf(888861533654745391L), "F14");
        var22[-557766224247783338L] = TuplesKt.to(Integer.valueOf(5182046070334554416L), "F15");
        var22[5174662325768028247L] = TuplesKt.to(Integer.valueOf(-133562358940303055L), "F16");
        var22[-2017489096917647272L] = TuplesKt.to(Integer.valueOf(-8032558251998445262L), "F17");
        var22[-7849830779650572199L] = TuplesKt.to(Integer.valueOf(9155578580837597491L), "F18");
        var22[-9163503199225642918L] = TuplesKt.to(Integer.valueOf(6591806121025995060L), "F19");
        var22[-4898396345523503013L] = TuplesKt.to(Integer.valueOf(-855596543795789515L), "F20");
        var22[-657963782584139684L] = TuplesKt.to(Integer.valueOf(-7447070595130326730L), "F21");
        var22[8627359433778790493L] = TuplesKt.to(Integer.valueOf(-1509214575390621385L), "F22");
        var22[495318602354786398L] = TuplesKt.to(Integer.valueOf(-85780581484330696L), "F23");
        var22[108130788133830751L] = TuplesKt.to(Integer.valueOf(-868731472909958855L), "F24");
        var22[-4452712498365202336L] = TuplesKt.to(Integer.valueOf(-9133391836348415686L), "F25");
        var22[-884028136373616543L] = TuplesKt.to(Integer.valueOf(-405726147200941760L), "NUM 0");
        var22[9035201823035621474L] = TuplesKt.to(Integer.valueOf(-8475792464559472319L), "NUM 1");
        var22[7269965234972917859L] = TuplesKt.to(Integer.valueOf(3769243005249126722L), "NUM 2");
        var22[7316629530657947748L] = TuplesKt.to(Integer.valueOf(8069901390614364483L), "NUM 3");
        var22[7653271167557435493L] = TuplesKt.to(Integer.valueOf(-7351449612210667196L), "NUM 4");
        var22[-749551889997103002L] = TuplesKt.to(Integer.valueOf(-7342917006842134203L), "NUM 5");
        var22[-5664232505239142297L] = TuplesKt.to(Integer.valueOf(-2481570024171503290L), "NUM 6");
        var22[4917661520113959016L] = TuplesKt.to(Integer.valueOf(2999992797504733511L), "NUM 7");
        var22[125905145216106601L] = TuplesKt.to(Integer.valueOf(-3169896223356223160L), "NUM 8");
        var22[3388988724237828202L] = TuplesKt.to(Integer.valueOf(207048158453170505L), "NUM 9");
        var22[-4043821875095142293L] = TuplesKt.to(Integer.valueOf(-2623766014701076150L), "Deci");
        var22[-7230427252104626068L] = TuplesKt.to(Integer.valueOf(-8682158251493555893L), "Div");
        var22[7935098636529041517L] = TuplesKt.to(Integer.valueOf(1228432136386642252L), "Mul");
        var22[3334183876388978798L] = TuplesKt.to(Integer.valueOf(-1277712342032842419L), "Sub");
        var22[4717322083397271663L] = TuplesKt.to(Integer.valueOf(1306119255728587086L), "Add");
        var22[8654892377464373360L] = TuplesKt.to(Integer.valueOf(3013111929729188175L), "Enter");
        var22[-7456625475729751951L] = TuplesKt.to(Integer.valueOf(-341619886247640752L), "Equal");
        var22[-1148763924724711310L] = TuplesKt.to(Integer.valueOf(8411000005271224660L), "Shift");
        var22[-3216784170873257869L] = TuplesKt.to(Integer.valueOf(-2977750815441157803L), "LCtrl");
        var22[-928921333574664076L] = TuplesKt.to(Integer.valueOf(8022627059249447254L), "LAlt");
        var22[-485605284706779019L] = TuplesKt.to(Integer.valueOf(-2592641915715321513L), "LSuper");
        var22[121250122221748342L] = TuplesKt.to(Integer.valueOf(5575305439303696728L), "RShift");
        var22[-8505580489413754761L] = TuplesKt.to(Integer.valueOf(5748834947129409881L), "RCtrl");
        var22[5538464511213699192L] = TuplesKt.to(Integer.valueOf(4468606488700518746L), "RAlt");
        var22[-7211993931075026823L] = TuplesKt.to(Integer.valueOf(7781651966282695003L), "RSuper");
        var22[-8557102629333761926L] = TuplesKt.to(Integer.valueOf(-4940811952185147044L), "Menu");
        lookupMap = MapsKt.mapOf();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
