package verification;


import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UkVerificationPolicyTest {

    @Test
    void shouldReturnRequirementsForUkLimitedCompany() {
        // Arrange
        Business business = new Business(
                Country.UNITED_KINGDOM,
                LegalEntityType.LIMITED_COMPANY
        );

        VerificationPolicy policy = new UkVerificationPolicy();

        // Act
        Set<RequirementType> requirements =
                policy.requirementsFor(business);

        // Assert
        assertEquals(
                Set.of(
                        RequirementType.COMPANY_REGISTRATION,
                        RequirementType.DIRECTOR_DETAILS,
                        RequirementType.BENEFICIAL_OWNER_DETAILS
                ),
                requirements
        );
    }
}
