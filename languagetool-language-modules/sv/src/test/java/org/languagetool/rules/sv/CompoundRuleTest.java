/* LanguageTool, a natural language style checker 
 * Copyright (C) 2011 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.rules.sv;

import org.languagetool.JLanguageTool;
import org.languagetool.TestTools;
import org.languagetool.language.Swedish;
import org.languagetool.rules.AbstractCompoundRuleTest;

import java.io.IOException;

public class CompoundRuleTest extends AbstractCompoundRuleTest {

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    langTool = new JLanguageTool(new Swedish());
    rule = new CompoundRule(TestTools.getEnglishMessages());
  }
  
  public void testRule() throws IOException {
    // correct:
    check(0, "skit-bra");
    check(0, "IP-Adress");
    check(0, "moll-tonart");
    check(0, "e-mail");
    // incorrect:
    check(1, "skit bra", new String[]{"skitbra"});
    check(1, "IP Adress", new String[]{"IP-Adress"});
    check(1, "moll tonart", new String[]{"moll-tonart", "molltonart"});
    check(1, "e mail", new String[]{"e-mail"});
  }
  
}
