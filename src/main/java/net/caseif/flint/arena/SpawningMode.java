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
package net.caseif.flint.arena;

/**
 * The mode by which spawn points in an arena are selected.
 *
 * @author Max Roncacé
 * @since 1.1
 */
public enum SpawningMode {

    /**
     * Spawn points will be selected in respective order.
     *
     * @since 1.1
     */
    SEQUENTIAL,
    /**
     * Spawn points will be selected completely randomly.
     *
     * @since 1.1
     */
    RANDOM,
    /**
     * Available spawn points will be shuffled and then selected sequentially
     * from the new, shuffled list.
     *
     * <p>Note: modifying an arena's spawn list will reset its shuffle order, as
     * will restarting/reloading the plugin.</p>
     *
     * @since 1.2
     */
    SHUFFLE,
    /**
     * Spawn points will be selected based on proximity to other players. The
     * spawn point with the greatest average distance to all other players in
     * the arena will be used.
     *
     * @since 1.2
     */
    PROXIMITY_HIGH

}
