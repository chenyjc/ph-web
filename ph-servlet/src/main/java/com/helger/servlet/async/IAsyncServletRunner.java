/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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
package com.helger.servlet.async;

import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Abstract layer to customize the handling of running a servlet request
 * asynchronously.
 *
 * @author Philip Helger
 * @since 8.7.5
 */
public interface IAsyncServletRunner
{
  /**
   * Run a servlet request asynchronously.
   *
   * @param aOriginalHttpResponse
   *        Original HTTP request. Never <code>null</code>.
   * @param aOriginalHttpRequest
   *        Original HTTP response. Never <code>null</code>.
   * @param aAsyncRunner
   *        The main runner that does the heavy lifting. Never
   *        <code>null</code>.
   * @param aAsyncContext
   *        The async execution context. Never <code>null</code>.
   */
  void runAsync (@Nonnull HttpServletRequest aOriginalHttpRequest,
                 @Nonnull HttpServletResponse aOriginalHttpResponse,
                 @Nonnull Consumer <ExtAsyncContext> aAsyncRunner,
                 @Nonnull ExtAsyncContext aAsyncContext);

  /**
   * Close all resources potentially allocated.
   */
  void shutdown ();
}
