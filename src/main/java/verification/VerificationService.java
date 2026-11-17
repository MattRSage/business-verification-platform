package verification;

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
}
