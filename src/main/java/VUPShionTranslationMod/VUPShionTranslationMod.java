package VUPShionTranslationMod;

import basemod.BaseMod;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.ISubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.core.Settings.GameLanguage;
import com.megacrit.cardcrawl.localization.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class VUPShionTranslationMod implements EditStringsSubscriber, EditKeywordsSubscriber {
    public static final Logger logger = LogManager.getLogger(VUPShionTranslationMod.class.getName());

    private static String modID;

    public VUPShionTranslationMod() {
        logger.info("Subscribe to BaseMod hooks");
        BaseMod.subscribe((ISubscriber) this);
        logger.info("Done subscribing");
        setModID("VUPShion-Translation");
    }

    public static void setModID(String ID) {
        modID = ID;
    }

    public static String getModID() {
        return modID;
    }

    public static void initialize() {
        logger.info("=========================== Initializing VUPShion Translation Mod ============================");
        VUPShionTranslationMod vupShionTranslationMod = new VUPShionTranslationMod();
        logger.info("=========================== /VUPShion Translation Mod Initialized/ ===========================");
    }

    public void receiveEditStrings() {
        String resourcesPath = "resources/localization/";

        if (Settings.language.equals(GameLanguage.ENG)) {
            BaseMod.loadCustomStringsFile(AchievementStrings.class, resourcesPath + "eng/AchievementStrings.json");
            BaseMod.loadCustomStringsFile(CardStrings.class, resourcesPath + "eng/CardStrings.json");
            BaseMod.loadCustomStringsFile(CharacterStrings.class, resourcesPath + "eng/CharacterStrings.json");
            BaseMod.loadCustomStringsFile(EventStrings.class, resourcesPath + "eng/EventStrings.json");
            BaseMod.loadCustomStringsFile(KeywordStrings.class, resourcesPath + "eng/KeywordStrings.json");
            BaseMod.loadCustomStringsFile(MonsterStrings.class, resourcesPath + "eng/MonsterStrings.json");
            BaseMod.loadCustomStringsFile(OrbStrings.class, resourcesPath + "eng/OrbStrings.json");
            BaseMod.loadCustomStringsFile(PotionStrings.class, resourcesPath + "eng/PotionStrings.json");
            BaseMod.loadCustomStringsFile(PowerStrings.class, resourcesPath + "eng/PowerStrings.json");
            BaseMod.loadCustomStringsFile(RelicStrings.class, resourcesPath + "eng/RelicStrings.json");
            BaseMod.loadCustomStringsFile(StanceStrings.class, resourcesPath + "eng/StanceStrings.json");
            BaseMod.loadCustomStringsFile(UIStrings.class, resourcesPath + "eng/UIStrings.json");
        }
    }

    public void receiveEditKeywords() {
        // Can add keywords
    }

    public static String makeID(String idText) {
        return getModID() + ":" + idText;
    }
}
