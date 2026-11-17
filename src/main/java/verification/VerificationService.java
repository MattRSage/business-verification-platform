package verification;

import java.util.List;
import java.util.Set;

public class VerificationService {

    private final VerificationPolicy verificationPolicy;
    private final VerificationRequirementsEvaluator verificationRequirementsEvaluator;

    public VerificationService(
            VerificationPolicy verificationPolicy,
            VerificationRequirementsEvaluator verificationRequirementsEvaluator
    ) {
        this.verificationPolicy = verificationPolicy;
        this.verificationRequirementsEvaluator = verificationRequirementsEvaluator;
    }

    public Set<RequirementType> findMissingRequirements(
            Business business,
            List<VerificationSubmission> submissions
    )
    {
        var requirements = this.verificationPolicy.requirementsFor(business);

        return this.verificationRequirementsEvaluator
                .findMissingRequirements(
                        requirements,
                        submissions);
    }
}
