package ciderblog.cider;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Random;

public class CiderDao {

    private final List<Cider> ciders = ImmutableList.of(
            new Cider("Jack Ratt Scrumpy Cider (Flagon)", "Lyme Bay Winery, Devon", "8.5", "£8.00 (per litre)", "Corge Castle, National Trust Gift Shop", "A delight of a still scrumpy cider, a very crisp medium dry variant of the scrumpy category. Really transports the drinker back to the era of the eighteenth centry wherein farms were granted a cider allowance of three pints a day. Similar to Malvern Gold. My day became brighter after consuming this beverage. It does not have any rubbish in it like Strongbow which is cack. The farmers did a good job. Would recommend. Adam stamp of recommend.", "Not a strong sneef. No recoil. pass"),
            new Cider("Forgotten Orchard", "Purbeck Cider Co., Kingston, Dorset", "8", "£2.39 (per 500 ml)", "Swanage, Co-Operative", "A gentle fizz which dissapears in the throat - almost like magic. There will be nothing forgotten about this orchard when given a try. Bursting with flavour, a decent medium dry variety cider. You can tell it's not reproduced with faecal matter, like Strongbow, which is cack. The Dorset farm folk did not dissapoint. Would recommend. Adam stamp of reccomend.", "Not too strong. Doesn't force recoil. Pass"),
            new Cider("Lulworth Skipper Dorset Cider", "Culcaze Lodge, Dorset", "7", "£3.00 (We got it on the cheap, 750ml)", "Purbeck Deli, Swanage", "You taste it, and you kind of don't like it. But then you realise you do like it, so you drink more. It's also really good for you, because it's 100% apple. Not like, 1% apple, like Strongbow. Nice colour. Nice opening bottle cap. Nice moth. Big friendly moth. Distinct taste. You'll know it's the Skipper by it's stillness and pleasant aftertaste. Very nice, just doesn't smell nice. Adam stamp of recommend.", "Weak, sour sneef. No recoil. Scraping pass."),
            new Cider("Jack Ratt Sparkling Cider", "Lyme Bay Winery, Devon", "4", "£3.50 (500ml)", "West Lulworth, Heritage Cider", "Sour tasting sparking cider. Tastes like liquefied skittles. Seems high in sugar content based on taste. It tastes similar to Stowford Press in taste. It has most definitely been refined and has that 'mass produced' feel about it. This is a moderate recommend. Adam half recommend. If you like things like Stowford. Still deosn't taste like Strongbow which means it is likely to not contain bleach.", "Strong urine-like smell. Recoil. Fails sneef test.")
    );

    public Iterable<Cider> getAllCiders() {
        return ciders;
    }

    public Cider getCiderByName(String name) {
        return ciders.stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
    }

    public Cider getRandomCider() {
        return ciders.get(new Random().nextInt(ciders.size()));
    }
}
