# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ed1a118f474eea5e159b560c339329b \
                    file://assignment-autotest/LICENSE;md5=cde0fddafb4332f35095da3d4fa989dd \
                    file://assignment-autotest/Unity/LICENSE.txt;md5=b7dd0dffc9dda6a87fa96e6ba7f9ce6c"

SRC_URI = "gitsm://github.com/cu-ecen-aeld/assignments-3-and-later-Yusufabdulsttar;protocol=https;branch=master"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "2484845e1cc922daa388fb18fa259a73fb5a2f9f"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

