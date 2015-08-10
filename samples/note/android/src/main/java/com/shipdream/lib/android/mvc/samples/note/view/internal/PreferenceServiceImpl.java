/*
 * Copyright 2015 Kejun Xia
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

package com.shipdream.lib.android.mvc.samples.note.view.internal;


import android.content.Context;
import android.content.SharedPreferences;

import com.shipdream.lib.android.mvc.samples.note.service.android.PreferenceService;

public class PreferenceServiceImpl implements PreferenceService {
    private SharedPreferences sharedPreferences;


    public PreferenceServiceImpl(Context context, String preferenceName, int mode){
        sharedPreferences = context.getSharedPreferences(preferenceName, mode);
    }

    @Override
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    @Override
    public Editor edit() {
        return new AndroidPreferenceEditor(sharedPreferences.edit());
    }

    private static class AndroidPreferenceEditor implements Editor{
        private SharedPreferences.Editor editor;
        AndroidPreferenceEditor(SharedPreferences.Editor andEditor){
            editor = andEditor;
        }

        @Override
        public Editor putInt(String key, int value) {
            return new AndroidPreferenceEditor(editor.putInt(key, value));
        }

        @Override
        public Editor putLong(String key, long value) {
            return new AndroidPreferenceEditor(editor.putLong(key, value));
        }

        @Override
        public Editor putFloat(String key, float value) {
            return new AndroidPreferenceEditor(editor.putFloat(key, value));
        }

        @Override
        public Editor putBoolean(String key, boolean value) {
            return new AndroidPreferenceEditor(editor.putBoolean(key, value));
        }

        @Override
        public Editor putString(String key, String value) {
            return new AndroidPreferenceEditor(editor.putString(key, value));
        }

        @Override
        public Editor clear() {
            return new AndroidPreferenceEditor(editor.clear());
        }

        @Override
        public boolean commit() {
            return editor.commit();
        }

        @Override
        public void apply() {
            editor.apply();
        }
    }
}
