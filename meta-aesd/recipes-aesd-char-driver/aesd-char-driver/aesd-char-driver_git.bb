# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8ed1a118f474eea5e159b560c339329b \
                    file://assignment-autotest/LICENSE;md5=cde0fddafb4332f35095da3d4fa989dd \
                    file://assignment-autotest/Unity/LICENSE.txt;md5=b7dd0dffc9dda6a87fa96e6ba7f9ce6c"

SRC_URI = "gitsm://github.com/cu-ecen-aeld/assignments-3-and-later-Yusufabdulsttar;protocol=https;branch=master /
           file://aesd-char-start-stop"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "2484845e1cc922daa388fb18fa259a73fb5a2f9f"

S = "${WORKDIR}/git/aesd-char-driver"

inherit module

EXTRA_OEMAKE:append:task-install = " -C ${STAGING_KERNEL_DIR} M=${S}"
EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"

# for start
inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "aesd-char-start-stop"

FILES:${PN} += "${sysconfdir}/init.d/aesd-char-start-stop"

FILES:${PN} += "${base_libdir}/modules/${KERNEL_VERSION}/aesdchar_load"
FILES:${PN} += "${base_libdir}/modules/${KERNEL_VERSION}/aesdchar_unload"

do_install () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/files/aesd-char-start-stop ${D}${sysconfdir}/init.d	
	
        install -d ${D}${bindir}
        install -m 0755 ${S}/aesdchar_load ${D}${bindir}
        install -m 0755 ${S}/aesdchar_unload ${D}${bindir}

	install -d ${D}/lib/modules/${KERNEL_VERSION}
	install -m 0755 ${S}/aesdchar.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}
}

