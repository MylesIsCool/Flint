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
package net.caseif.flint.component;

import net.caseif.flint.component.exception.OrphanedComponentException;

/**
 * Represents an object which is owned by a {@link ComponentOwner}.
 *
 * <p>All {@link Component}s are inherently orphanable. An object is considered
 * orphaned when it is dissociated from its parent container, leaving it for all
 * intents and purposes obsolete. Orphaned objects will throw an
 * {@link OrphanedComponentException} in response to any defined method being
 * invoked upon them.</p>
 *
 * @param <T> The {@link ComponentOwner} type this {@link Component} is owned
 *     by
 * @since 1.0
 */
public interface Component<T extends ComponentOwner> {

    /**
     * Gets the {@link ComponentOwner owner} of this object.
     *
     * @throws OrphanedComponentException If this object is orphaned (see
     *     {@link Component} for details)
     * @return The {@link ComponentOwner owner} of this object
     * @since 1.0
     */
    T getOwner() throws OrphanedComponentException;

}