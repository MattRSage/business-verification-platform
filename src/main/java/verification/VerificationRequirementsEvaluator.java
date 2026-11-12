package verification;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VerificationRequirementsEvaluator {

    public Set<RequirementType> findMissingRequirements(
            Set<RequirementType> required,
            List<VerificationSubmission> submissions
    ) {
        return required.stream()
                .filter(requirement ->
                        submissions.stream().noneMatch(s ->
                                s.requirementType() == requirement
                                        && s.completed()
                        )
                )
                .collect(Collectors.toSet());
    }
}

