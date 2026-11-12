package verification;

import java.util.Objects;

public record Business(
        Country country,
        LegalEntityType legalEntityType
) {
    public Business {
        Objects.requireNonNull(country, "Country is required");
        Objects.requireNonNull(legalEntityType, "Legal entity type is required");
    }
}
