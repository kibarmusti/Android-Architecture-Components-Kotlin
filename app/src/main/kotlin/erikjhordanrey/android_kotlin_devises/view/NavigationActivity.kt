/**
 * Copyright 2017 Erik Jhordan Rey.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package erikjhordanrey.android_kotlin_devises.view

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import erikjhordanrey.android_kotlin_devises.R


class NavigationActivity : LifecycleActivity(), BottomNavigationView.OnNavigationItemSelectedListener {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initUI()
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.navigation_home -> {
        replaceFragment(CurrencyFragment.newInstance())
        return true
      }
      R.id.navigation_dashboard -> {
        replaceFragment(AboutFragment.newInstance())
        return true
      }
    }
    return false
  }

  private fun initUI() {
    replaceFragment(CurrencyFragment.newInstance())
    initNavigation()
  }

  private fun initNavigation() {
    val navigation = findViewById(R.id.navigation) as BottomNavigationView
    navigation.setOnNavigationItemSelectedListener(this)
  }

  private fun replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.content, fragment)
        .commit()
  }

}
