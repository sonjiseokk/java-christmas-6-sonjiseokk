package christmas.domain.event;

public class Benefit {
    private DiscountType discountType;
    private Integer discount;

    public Benefit(final DiscountType discountType, final Integer discount) {
        this.discountType = discountType;
        this.discount = discount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public Integer getDiscount() {
        return discount;
    }
}
