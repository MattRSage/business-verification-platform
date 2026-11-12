package verification;


import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void shouldReturnRequirementsForUkSoleTrader() {
        // Arrange
        Business business = new Business(
                Country.UNITED_KINGDOM,
                LegalEntityType.SOLE_TRADER
        );

        VerificationPolicy policy = new UkVerificationPolicy();

        // Act
        Set<RequirementType> requirements =
                policy.requirementsFor(business);

        // Assert
        assertEquals(
                Set.of(
                        RequirementType.IDENTITY,
                        RequirementType.BUSINESS_ADDRESS
                ),
                requirements
        );
    }


    @Test
    void shouldRejectBusinessWithUnsupportedCountry() {
        // Arrange
        Business business = new Business(
                Country.GERMANY,
                LegalEntityType.LIMITED_COMPANY
        );

        VerificationPolicy policy = new UkVerificationPolicy();

        // Act & Assert
        assertThrows(
                UnsupportedCountryException.class,
                () -> policy.requirementsFor(business)
        );
    }


    @Test
    void shouldRejectNullBusiness() {
        VerificationPolicy policy = new UkVerificationPolicy();

        assertThrows(
                IllegalArgumentException.class,
                () -> policy.requirementsFor(null)
        );
    }

    @Test
    void shouldRejectBusinessWithoutLegalEntityType() {
        assertThrows(
                NullPointerException.class,
                () -> new Business(Country.UNITED_KINGDOM, null)
        );
    }
}
