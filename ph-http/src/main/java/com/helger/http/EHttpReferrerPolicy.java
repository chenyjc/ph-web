/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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
package com.helger.http;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.DevelopersNote;

/**
 * HTTP response header "Referrer-Policy" values. See
 * https://scotthelme.co.uk/a-new-security-header-referrer-policy/
 *
 * @author Philip Helger
 */
public enum EHttpReferrerPolicy
{
  NONE (""),
  NO_REFERRER ("no-referrer"),
  NO_REFERRER_WHEN_DOWNGRADE ("no-referrer-when-downgrade"),
  // Not supported in Chrome 59
  SAME_ORIGIN ("same-origin"),
  ORIGIN ("origin"),
  // Not supported in Chrome 59
  STRICT_ORIGIN ("strict-origin"),
  ORIGIN_WHEN_CROSS_ORIGIN ("origin-when-cross-origin"),
  // Not supported in Chrome 59
  STRICT_ORIGIN_WHEN_CROSS_ORIGIN ("strict-origin-when-cross-origin"),
  UNSAFE_URL ("unsafe-url");

  @Deprecated
  @DevelopersNote ("Old name")
  public static final EHttpReferrerPolicy _SAME_ORIGIN = SAME_ORIGIN;

  @Deprecated
  @DevelopersNote ("Old name")
  public static final EHttpReferrerPolicy _STRICT_ORIGIN = STRICT_ORIGIN;

  @Deprecated
  @DevelopersNote ("Old name")
  public static final EHttpReferrerPolicy _STRICT_ORIGIN_WHEN_CROSS_ORIGIN = STRICT_ORIGIN_WHEN_CROSS_ORIGIN;

  private String m_sValue;

  private EHttpReferrerPolicy (@Nonnull final String sValue)
  {
    m_sValue = sValue;
  }

  @Nonnull
  public String getValue ()
  {
    return m_sValue;
  }
}
