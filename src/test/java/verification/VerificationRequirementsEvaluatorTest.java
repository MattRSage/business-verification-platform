package verification;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerificationRequirementsEvaluatorTest {

    @Test
    void shouldFindMissingVerificationRequirements() {
        //Arrange
        Set<RequirementType> required = Set.of(
                RequirementType.COMPANY_REGISTRATION,
                RequirementType.DIRECTOR_DETAILS
        );

        List<VerificationSubmission> submissions = List.of(
                new VerificationSubmission(
                        RequirementType.COMPANY_REGISTRATION,
                        true
                )
        );

        var verificationRequirementsEvaluator = new VerificationRequirementsEvaluator();

        // Act
        var missing = verificationRequirementsEvaluator.findMissingRequirements(
                required,
                submissions
        );

        // Assert
        assertEquals(
                Set.of(
                        RequirementType.DIRECTOR_DETAILS
                ),
                missing
        );
    }

    @Test
    void shouldReturnEmptySetWhenAllRequirementsCompleted(){
        //Arrange
        Set<RequirementType> required = Set.of(
                RequirementType.COMPANY_REGISTRATION,
                RequirementType.DIRECTOR_DETAILS
        );

        List<VerificationSubmission> submissions = List.of(
                new VerificationSubmission(
                        RequirementType.COMPANY_REGISTRATION,
                        true
                ),
                new VerificationSubmission(
                        RequirementType.DIRECTOR_DETAILS,
                        true
                )
        );

        var verificationRequirementsEvaluator = new VerificationRequirementsEvaluator();

        // Act
        var missing = verificationRequirementsEvaluator.findMissingRequirements(
                required,
                submissions
        );

        // Assert
        assertEquals(
                missing,
                Set.of()
        );
    }

    @Test
    void shouldReturnAllRequirementsWhenNoSubmissionsExist(){
        //Arrange
        Set<RequirementType> required = Set.of(
                RequirementType.COMPANY_REGISTRATION,
                RequirementType.DIRECTOR_DETAILS
        );

        List<VerificationSubmission> noSubmissions = List.of();

        var verificationRequirementsEvaluator = new VerificationRequirementsEvaluator();

        // Act
        var missing = verificationRequirementsEvaluator.findMissingRequirements(
                required,
                noSubmissions
        );

        // Assert
        assertEquals(
                missing,
                Set.of(
                        RequirementType.COMPANY_REGISTRATION,
                        RequirementType.DIRECTOR_DETAILS
                )
        );
    }

    @Test
    void shouldReturnMissingRequirementsWhenSubmissionIsIncomplete() {
        //Arrange
        Set<RequirementType> required = Set.of(
                RequirementType.COMPANY_REGISTRATION,
                RequirementType.DIRECTOR_DETAILS
        );

        List<VerificationSubmission> submissions = List.of(
                new VerificationSubmission(
                        RequirementType.COMPANY_REGISTRATION,
                        true
                ),
                new VerificationSubmission(
                        RequirementType.DIRECTOR_DETAILS,
                        false
                )
        );

        var verificationRequirementsEvaluator = new VerificationRequirementsEvaluator();

        // Act
        var missing = verificationRequirementsEvaluator.findMissingRequirements(
                required,
                submissions
        );

        // Assert
        assertEquals(
                missing,
                Set.of(
                        RequirementType.DIRECTOR_DETAILS
                )
        );
    }
}
