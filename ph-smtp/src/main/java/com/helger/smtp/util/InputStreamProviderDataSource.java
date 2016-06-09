/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.smtp.util;

import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.UnsupportedOperation;
import com.helger.commons.io.IHasInputStream;
import com.helger.commons.mime.CMimeType;
import com.helger.commons.mime.IMimeType;
import com.helger.commons.string.ToStringGenerator;

/**
 * A special {@link DataSource} implementation based on data from
 * {@link IHasInputStream}.
 *
 * @author Philip Helger
 */
public class InputStreamProviderDataSource implements DataSource
{
  public static final IMimeType DEFAULT_CONTENT_TYPE = CMimeType.APPLICATION_OCTET_STREAM;

  private final IHasInputStream m_aISP;
  private final String m_sFilename;
  private final String m_sContentType;

  public InputStreamProviderDataSource (@Nonnull final IHasInputStream aISP, @Nonnull final String sFilename)
  {
    this (aISP, sFilename, (String) null);
  }

  public InputStreamProviderDataSource (@Nonnull final IHasInputStream aISP,
                                        @Nonnull final String sFilename,
                                        @Nullable final IMimeType aContentType)
  {
    this (aISP, sFilename, aContentType == null ? null : aContentType.getAsString ());
  }

  public InputStreamProviderDataSource (@Nonnull final IHasInputStream aISP,
                                        @Nonnull final String sFilename,
                                        @Nullable final String sContentType)
  {
    m_aISP = ValueEnforcer.notNull (aISP, "InputStreamProvider");
    m_sFilename = ValueEnforcer.notNull (sFilename, "Filename");
    m_sContentType = sContentType != null ? sContentType : DEFAULT_CONTENT_TYPE.getAsString ();
  }

  @Nonnull
  public String getContentType ()
  {
    return m_sContentType;
  }

  @Nonnull
  public String getName ()
  {
    return m_sFilename;
  }

  @Nullable
  public InputStream getInputStream ()
  {
    return m_aISP.getInputStream ();
  }

  @UnsupportedOperation
  public OutputStream getOutputStream ()
  {
    throw new UnsupportedOperationException ("Read-only!");
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("ISP", m_aISP)
                                       .append ("Filename", m_sFilename)
                                       .appendIfNotNull ("ContentType", m_sContentType)
                                       .toString ();
  }
}