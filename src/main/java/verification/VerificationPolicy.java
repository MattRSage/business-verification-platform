package verification;

import java.util.Set;

public interface VerificationPolicy {
    Set<RequirementType> requirementsFor(Business business);
}

