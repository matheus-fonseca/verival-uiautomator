#!/bin/bash

cd VerivalUiautomator/

echo -e "########################\n\tBUILD\n########################"
ant build
if [[ "$?" -ne "0" ]]
then
	echo -e "\nErro no BUILD. Saindo..."
	exit -1
fi

echo -e "\n########################\n\tDEPLOY\n########################"
adb push src/resources/strings_pt-BR.properties /data/local/tmp/
adb push src/resources/strings_en-US.properties /data/local/tmp/
adb push bin/VerivalUiautomator.jar /data/local/tmp/
if [[ "$?" -ne "0" ]]
then
	echo -e "\nErro no DEPLOY. Saindo..."
	exit -1
fi

echo -e "\n########################\n\tTESTS\n########################"
adb shell uiautomator runtest VerivalUiautomator.jar -c br.unb.vvs.uiautomator.Test01_20minutesCall | grep -v INSTRUMENTATION_STATUS
adb shell uiautomator runtest VerivalUiautomator.jar -c br.unb.vvs.uiautomator.Test02_40SequencedCalls | grep -v INSTRUMENTATION_STATUS
adb shell uiautomator runtest VerivalUiautomator.jar -c br.unb.vvs.uiautomator.Test04_callEmergencyNumbers | grep -v INSTRUMENTATION_STATUS
adb shell uiautomator runtest VerivalUiautomator.jar -c br.unb.vvs.uiautomator.Test06_Send100TextMessage | grep -v INSTRUMENTATION_STATUS
adb shell uiautomator runtest VerivalUiautomator.jar -c br.unb.vvs.uiautomator.Test05_TurnOnOffAdapters | grep -v INSTRUMENTATION_STATUS
adb shell uiautomator runtest VerivalUiautomator.jar -c br.unb.vvs.uiautomator.Test07_SendVerifyEmail | grep -v INSTRUMENTATION_STATUS 
adb shell uiautomator runtest VerivalUiautomator.jar -c br.unb.vvs.uiautomator.Test08_Add1000NewContacts | grep -v INSTRUMENTATION_STATUS 