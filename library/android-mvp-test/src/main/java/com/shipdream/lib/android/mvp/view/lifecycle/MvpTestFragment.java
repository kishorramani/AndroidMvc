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

package com.shipdream.lib.android.mvp.view.lifecycle;

import android.os.Bundle;
import android.view.View;

import com.shipdream.lib.android.mvp.view.MvpApp;
import com.shipdream.lib.android.mvp.MvpFragment;
import com.shipdream.lib.android.mvp.view.help.LifeCycleMonitor;
import com.shipdream.lib.android.mvp.view.test.R;

public class MvpTestFragment extends MvpFragment {
    private LifeCycleMonitor lifeCycleMonitor = MvpApp.lifeCycleMonitorFactory.provideLifeCycleMonitor();

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mvc_test;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifeCycleMonitor.onCreate(savedInstanceState);
    }

    @Override
    public void onViewReady(View view, Bundle savedInstanceState, Reason reason) {
        lifeCycleMonitor.onCreateView(view, savedInstanceState);
        lifeCycleMonitor.onViewCreated(view, savedInstanceState);
        super.onViewReady(view, savedInstanceState, reason);
        lifeCycleMonitor.onViewReady(view, savedInstanceState, reason);
    }

    @Override
    public void onResume() {
        super.onResume();
        lifeCycleMonitor.onResume();
    }

    @Override
    protected void onReturnForeground() {
        super.onReturnForeground();
        lifeCycleMonitor.onReturnForeground();
    }

    @Override
    protected void onPushingToBackStack() {
        super.onPushingToBackStack();
        lifeCycleMonitor.onPushingToBackStack();
    }

    @Override
    protected void onPoppedOutToFront() {
        super.onPoppedOutToFront();
        lifeCycleMonitor.onPoppedOutToFront();
    }

    @Override
    protected void onOrientationChanged(int lastOrientation, int currentOrientation) {
        super.onOrientationChanged(lastOrientation, currentOrientation);
        lifeCycleMonitor.onOrientationChanged(lastOrientation, currentOrientation);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        lifeCycleMonitor.onDestroyView();
    }

    @Override
    public void onDestroy() {
        lifeCycleMonitor.onDestroy();
        super.onDestroy();
    }
}