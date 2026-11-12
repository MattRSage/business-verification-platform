package verification;

public record VerificationSubmission(
        RequirementType requirementType,
        boolean completed
) {}
