/*
 * Copyright 2013, WoQ - Way of Quality UG(mbH)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.woq.osgi.java.itestsupport;

class ProfileResolver {

  private ProfileResolver() {}

  protected static ContainerProfile resolveProfile(final Class<?> clazz) throws Exception {

    ContainerProfile result = null;
    Class<?> currentClass = clazz;

    while(result == null && currentClass != null) {
      result = currentClass.getAnnotation(ContainerProfile.class);
      currentClass = currentClass.getSuperclass();
    }

    return  result;
  }
}