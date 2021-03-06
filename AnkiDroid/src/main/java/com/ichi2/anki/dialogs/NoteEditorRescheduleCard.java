
package com.ichi2.anki.dialogs;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.InputType;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ichi2.anki.NoteEditor;
import com.ichi2.anki.R;

public class NoteEditorRescheduleCard extends DialogFragment {
    public static NoteEditorRescheduleCard newInstance() {
        return new NoteEditorRescheduleCard();
    }


    @Override
    public MaterialDialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        return new MaterialDialog.Builder(getActivity())
                .title(R.string.reschedule_card_dialog_title)
                .positiveText(getResources().getString(R.string.dialog_ok))
                .negativeText(R.string.cancel)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input(R.string.reschedule_card_dialog_message, R.string.empty_string, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence text) {
                        int days = Integer.parseInt(text.toString());
                        ((NoteEditor) getActivity()).onRescheduleCard(days);
                    }
                })
                .show();
    }
    }
