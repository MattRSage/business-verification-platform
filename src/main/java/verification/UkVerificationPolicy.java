package verification;

import java.util.Set;

public class UkVerificationPolicy implements VerificationPolicy {

    @Override
    public Set<RequirementType> requirementsFor(Business business) {
        return Set.of(
                RequirementType.BENEFICIAL_OWNER_DETAILS,
                RequirementType.COMPANY_REGISTRATION,
                RequirementType.DIRECTOR_DETAILS);
    }
}
