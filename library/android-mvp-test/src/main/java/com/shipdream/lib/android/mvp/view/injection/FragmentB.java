/*
 * Copyright 2016 Kejun Xia
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

package com.shipdream.lib.android.mvp.view.injection;

import android.os.Bundle;
import android.view.View;

import com.shipdream.lib.android.mvp.view.MvpApp;
import com.shipdream.lib.android.mvp.view.help.LifeCycleMonitor;
import com.shipdream.lib.android.mvp.view.help.LifeCycleMonitorB;
import com.shipdream.lib.android.mvp.view.injection.presenter.PresenterA;
import com.shipdream.lib.android.mvp.view.injection.presenter.PresenterB;

import javax.inject.Inject;

public class FragmentB extends FragmentInjection {
    @Inject
    private PresenterA presenterA;

    //TODO: should be removed if designed correctly
    @Inject
    private PresenterB presenterB;

    private LifeCycleMonitorB lifeCycleMonitorB = MvpApp.lifeCycleMonitorFactory.provideLifeCycleMonitorB();

    @Override
    protected void setUpData() {
        presenterA.addTag("Added by " + getClass().getSimpleName());
        presenterB.addTag("Added by " + getClass().getSimpleName());
    }

    @Override
    protected LifeCycleMonitor getLifeCycleMonitor() {
        return lifeCycleMonitorB;
    }

    @Override
    public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
        super.onViewReady(view, savedInstanceState, reason);
        displayTags(textViewA, presenterA.getTags());
        displayTags(textViewB, presenterB.getTags());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}