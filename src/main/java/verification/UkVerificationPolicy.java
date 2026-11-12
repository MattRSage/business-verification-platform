package verification;

import java.util.Set;

public class UkVerificationPolicy implements VerificationPolicy {

    @Override
    public Set<RequirementType> requirementsFor(Business business) {

        if (business == null) {
            throw new IllegalArgumentException();
        }

        if (business.country() == Country.GERMANY){
            throw new UnsupportedCountryException();
        }

        return switch (business.legalEntityType()) {
            case LIMITED_COMPANY -> Set.of(
                    RequirementType.BENEFICIAL_OWNER_DETAILS,
                    RequirementType.COMPANY_REGISTRATION,
                    RequirementType.DIRECTOR_DETAILS);
            case SOLE_TRADER -> Set.of(
                    RequirementType.IDENTITY,
                    RequirementType.BUSINESS_ADDRESS);
        };
    }
}
