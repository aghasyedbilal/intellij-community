/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.lang.spi;

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

/**
 * @author peter
 */
public class SPICompletionTest extends LightCodeInsightFixtureTestCase {

  public void testQualifiedReference() {
    myFixture.addClass("package com.foo; public class Interface {}");
    myFixture.addClass("package com.foo; public class Implementation extends Interface {}");
    myFixture.configureFromExistingVirtualFile(
      myFixture.addFileToProject("META-INF/services/com.foo.Interface", "com.f<caret>").getVirtualFile());
    myFixture.completeBasic();
    myFixture.checkResult("com.foo.Implementation");
  }

}
