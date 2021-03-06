package mage.cards.a;

import java.util.UUID;

import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfCombatTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.FullPartyCondition;
import mage.abilities.decorator.ConditionalInterveningIfTriggeredAbility;
import mage.abilities.dynamicvalue.common.PartyCount;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.abilities.effects.common.continuous.GainAbilityTargetEffect;
import mage.abilities.effects.common.continuous.SetPowerSourceEffect;
import mage.abilities.hint.common.PartyCountHint;
import mage.abilities.keyword.FlyingAbility;
import mage.constants.*;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.target.common.TargetCreaturePermanent;

/**
 * @author TheElk801
 */
public final class ArchpriestOfIona extends CardImpl {

    public ArchpriestOfIona(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{W}");

        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.CLERIC);
        this.power = new MageInt(0);
        this.toughness = new MageInt(2);

        // Archpriest of Iona's power is equal to the number of creatures in your party.
        this.addAbility(new SimpleStaticAbility(
                Zone.ALL, new SetPowerSourceEffect(PartyCount.instance, Duration.EndOfGame)
        ).addHint(PartyCountHint.instance));

        // At the beginning of combat on your turn, if you have a full party, target creature gets +1/+1 and gains flying until end of turn.
        Ability ability = new ConditionalInterveningIfTriggeredAbility(
                new BeginningOfCombatTriggeredAbility(
                        new BoostTargetEffect(1, 1, Duration.EndOfTurn),
                        TargetController.YOU, false
                ), FullPartyCondition.instance, "At the beginning of combat on your turn, " +
                "if you have a full party, target creature gets +1/+1 and gains flying until end of turn."
        );
        ability.addEffect(new GainAbilityTargetEffect(FlyingAbility.getInstance(), Duration.EndOfTurn));
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
    }

    private ArchpriestOfIona(final ArchpriestOfIona card) {
        super(card);
    }

    @Override
    public ArchpriestOfIona copy() {
        return new ArchpriestOfIona(this);
    }
}
