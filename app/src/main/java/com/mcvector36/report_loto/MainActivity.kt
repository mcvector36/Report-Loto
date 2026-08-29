
package com.mcvector36.report_loto

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.mcvector36.report_loto.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ascunde bara de sus "Report-Loto"
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter =
                SectionsPagerAdapter(
                        this,
                        supportFragmentManager
                )

        val viewPager: ViewPager =
                findViewById(R.id.view_pager)

        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout =
                findViewById(R.id.tabs)

        tabs.setupWithViewPager(viewPager)
    }
}