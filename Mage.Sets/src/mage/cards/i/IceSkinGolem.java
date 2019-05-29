package mage.cards.i;

import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.InfoEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.SuperType;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class IceSkinGolem extends CardImpl {

    public IceSkinGolem(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ARTIFACT, CardType.CREATURE}, "{S}");

        this.addSuperType(SuperType.SNOW);
        this.subtype.add(SubType.GOLEM);
        this.power = new MageInt(2);
        this.toughness = new MageInt(2);

        // ({S} can be paid with one mana from a snow permanent.)
        this.addAbility(new SimpleStaticAbility(
                new InfoEffect("<i>({S} can be paid with one mana from a snow permanent.)</i>")
        ));
    }

    private IceSkinGolem(final IceSkinGolem card) {
        super(card);
    }

    @Override
    public IceSkinGolem copy() {
        return new IceSkinGolem(this);
    }
}