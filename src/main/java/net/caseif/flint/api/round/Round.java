/*
 * New BSD License (BSD-new)
 *
 * Copyright (c) 2015 Maxim Roncacé
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     - Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     - Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     - Neither the name of the copyright holder nor the names of its contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.caseif.flint.api.round;

import net.caseif.flint.api.Arena;
import net.caseif.flint.api.feedback.JoinResult;
import net.caseif.flint.api.util.Metadatable;

import com.google.common.base.Optional;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represents an active minigame {@link Round} backed by Flint.
 *
 * @author Max Roncacé
 * @since 0.1.0
 */
public interface Round extends Metadatable {

    /**
     * Gets the {@link Arena} which contains this {@link Round}.
     *
     * @return The {@link Arena} which contains this {@link Round}
     * @since 0.1.0
     */
    Arena getArena();

    /**
     * Returns an immutable {@link Set} of {@link Player}s in this
     * {@link Round}.
     * @return An immutable {@link Set} of {@link Player}s in this
     * {@link Round}
     * @since 0.1.0
     */
    Set<Player> getPlayers();

    /**
     * Adds the given {@link Player} to this {@link Round}.
     *
     * @param player The player to add to this {@link Round}
     * @return The result of the player joining the round
     * @since 0.1.0
     */
    JoinResult addPlayer(Player player);

    /**
     * Removes the given player from this {@link Round}.
     *
     * @param player The player to remove from this {@link Round}
     * @since 0.1.0
     */
    void removePlayer(Player player);

    /**
     * Gets this {@link Round}'s defined lifecycle stages.
     *
     * @return This {@link Round}'s defined lifecycle stages
     * @since 0.1.0
     */
    LinkedHashSet<LifecycleStage> getLifecycleStages();

    /**
     * Defines this {@link Round}'s lifecycle stages.
     *
     * @param stages The new lifecycle stages to define
     * @since 0.1.0
     */
    void setLifecycleStages(LinkedHashSet<LifecycleStage> stages);

    /**
     * Gets this {@link Round}'s current lifecycle stage.
     *
     * @return This {@link Round}'s current lifecycle stage.
     * @since 0.1.0
     */
    LifecycleStage getLifecycleStage();

    /**
     * Gets this {@link Round}'s next lifecycle stage, if applicable.
     *
     * @return This {@link Round}'s next lifecycle stage, or
     *         {@link Optional#absent()} if the current stage is the final
     *         defined
     * @since 0.1.0
     */
    Optional<LifecycleStage> getNextLifecycleStage();

    /**
     * Gets the current state of this {@link Round}'s timer in seconds.
     *
     * <p>Typically, this represents the time since its last lifecycle stage
     * change, although this is not absolute.</p>
     *
     * @return The current state of this {@link Round}'s timer in seconds
     * @since 0.1.0
     */
    int getTime();

    /**
     * Sets the current state of this {@link Round}'s timer in seconds.
     *
     * @param time The current state of this {@link Round}'s timer in seconds
     * @since 0.1.0
     */
    void setTime(int time);

    /**
     * Gets the time in seconds until this {@link Round} is due to change
     * its lifecycle stage.
     *
     * @return The time in seconds until this {@link Round} is due to change
     * its lifecycle stage, or <code>-1</code> if the current stage is untimed.
     * @since 0.1.0
     */
    int getRemainingTime();

    /**
     * Starts this {@link Round}'s timer in its current state.
     *
     * @since 0.1.0
     */
    void startTimer();

    /**
     * Stops this {@link Round}'s timer. Note that this does not end the round.
     *
     * @since 0.1.0
     */
    void stopTimer();

    /**
     * Sets this {@link Round}'s lifecycle stage to its initial state and resets
     * and stops the timer.
     *
     * @since 0.1.0
     */
    void reset();

    /**
     * Ends this round by rolling back its arena and removing all players.
     *
     * @since 0.1.0
     */
    void end();

}
