/**
 * Copyright (C) 2016-2017 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.xservlet.handler;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.servlet.ServletException;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsMap;

/**
 * Base interface for regular and simpler handler
 *
 * @author Philip Helger
 * @since 9.0.0
 */
public interface IXServletBasicHandler extends Serializable
{
  /**
   * Called upon Servlet initialization
   *
   * @param sApplicationID
   *        The determined application ID of this servlet. Neither
   *        <code>null</code> nor empty.
   * @param aInitParams
   *        The init parameters. Never <code>null</code> but maybe empty.
   * @throws ServletException
   *         if something goes wrong
   */
  default void onServletInit (@Nonnull @Nonempty final String sApplicationID,
                              @Nonnull final ICommonsMap <String, String> aInitParams) throws ServletException
  {}

  /**
   * Called upon Servlet destruction. May not throw an exception!
   */
  default void onServletDestroy ()
  {}
}