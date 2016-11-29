/*
 * SonarLint for Eclipse
 * Copyright (C) 2015-2016 SonarSource SA
 * sonarlint@sonarsource.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarlint.eclipse.core.internal.tracking;

import java.util.Collection;

import org.sonarlint.eclipse.core.internal.SonarLintCorePlugin;

public class TrackingChangeSubmitter {

  private final TrackingChangeQueueManager queueManager;
  private final String moduleKey;

  public TrackingChangeSubmitter(TrackingChangeQueueManager queueManager, String moduleKey) {
    this.queueManager = queueManager;
    this.moduleKey = moduleKey;
  }

  public void submit(String file, Collection<Trackable> issues) {
    //queueManager.post(moduleKey, file, issues);
    SonarLintCorePlugin.getDefault().markerUpdater().onTrackingChange(moduleKey, file, issues);
  }

}
