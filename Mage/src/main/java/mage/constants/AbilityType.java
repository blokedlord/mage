package mage.constants;

/**
 * @author North
 */
public enum AbilityType {
    PLAY_LAND("Play land", true),
    MANA("Mana", false),
    SPELL("Spell", true),
    ACTIVATED("Activated", false),
    STATIC("Static", false),
    TRIGGERED("Triggered", false),
    EVASION("Evasion", false),
    LOYALTY("Loyalty", false),
    SPECIAL_ACTION("Special Action", false);

    private final String text;
    private final boolean playCardAbility;

    AbilityType(String text, boolean playCardAbility) {
        this.text = text;
        this.playCardAbility = playCardAbility;
    }

    @Override
    public String toString() {
        return text;
    }

    public boolean isPlayCardAbility() {
        return playCardAbility;
    }
}
