package org.adoptopenjdk.lambda.tutorial.exercise2;

/*
 * #%L
 * lambda-tutorial
 * %%
 * Copyright (C) 2013 Adopt OpenJDK
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Some (inaccurate) London electrical districts
 * 
 * Lambda Tutorial -- Adopt Open JDK
 *
 * @author Graham Allan grundlefleck at gmail dot com
 */
public enum ElectoralDistrict {

    CROYDON("CR"),
    BARKING("BA"),
    HACKNEY("HA"),
    EDMONTON("ED");

    private final String prefix;

    ElectoralDistrict(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Complete this method to pass Exercise_2_Test#setOfVotersInDistrict()
     * 
     * @param district - District to vote in
     * @param voters - voters to filter
     * @return filtered set of registered voters in a district
     */
    public static Set<RegisteredVoter> votersIn(ElectoralDistrict district, Collection<RegisteredVoter> voters) {
//        First return (line below) was written to satisfy the first test.  Upon seeing the fourth test, I rewrote the original return and replaced with final return below.
//        return voters.stream().filter(voter -> voter.getElectorId().contains(district.getPrefix())).collect(Collectors.toSet());
        return Collections.unmodifiableSet(voters.stream().filter(voter->voter.getElectorId().contains(district.getPrefix())).collect(Collectors.toSet()));
    }

    /**
     * Complete this method to pass Exercise_2_Test#removeAllSpoiledBallots()
     * 
     * @param ballots - ballots to filter
     * @return filtered set of unspoiled ballots
     */
    public static Set<Ballot> unspoiledBallots(Set<Ballot> ballots) {
        return ballots.stream().filter(ballot -> ballot.getParty()!=null).collect(Collectors.toSet());
    }

    public String getPrefix() {
        return prefix;
    }
}

