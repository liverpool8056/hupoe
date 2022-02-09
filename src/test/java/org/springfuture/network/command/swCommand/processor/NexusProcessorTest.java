package org.springfuture.network.command.swCommand.processor;

import org.springfuture.network.bean.*;
import org.springfuture.network.ssh.ExpectResult;
import org.springfuture.network.ssh.SSH;
import org.springfuture.network.ssh.exception.ChannelClosedException;
import org.springfuture.network.ssh.exception.ConnectionException;
import org.springfuture.network.ssh.exception.ExpectTimeoutException;
import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NexusProcessorTest {

    @Test
    public void sshTest(){
        String[] cmds = {"conf t", "int e1/16", "shut", "end", "exit"};
        final String LOGIN_EXPECT = "[A-Z]{2}-[A-Z]{2}-[A|B]-.+-\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.*[>|#]";
        final String CONFIG_EXPECT = "[A-Z]{2}-[A-Z]{2}-[A|B]-.+-\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}-[A-Z]{2}(config.*)#";
        System.out.println("Start...");
        SSH ssh = new SSH("sensepxe", "senset1me@1DCnet&", "10.5.255.17");
        try {
            ssh.connect();
            try {
                ExpectResult expectResult = ssh.expect(Arrays.asList(LOGIN_EXPECT), 3);
                System.out.println(expectResult.getMatchedString());
            } catch (ExpectTimeoutException | ChannelClosedException | InterruptedException e) {
                System.out.println("backlog is: "+ssh.getOutputBacklog());
            }
        } catch (ConnectionException e) {
            e.printStackTrace();
        }finally {
            ssh.close();
            System.out.println("Finish");
        }
    }

    @Test
    public void deviceRegTest(){
        String a = "******************************************************************************\n" +
                "* Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.*\n" +
                "* Without the owner's prior written consent,                                 *\n" +
                "* no decompiling or reverse-engineering shall be allowed.                    *\n" +
                "******************************************************************************\n" +
                "\n" +
                "<SH-YF-C-9820-10.5.255.17>";

        String pattern = "[A-Z]{2}-[A-Z]{2}-[ABC]-.+-\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.*[>|#]";

        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(a);
        if(matcher.find()){
            System.out.println("find");
        }else{
            System.out.println("not found");
        }
    }

    @Test
    public void lldpProcessor(){
        String output = "SH-YF-A-N5K-192.168.100.53-IP# sh lldp neighbors detail\n" +
                "Capability codes:\n" +
                "  (R) Router, (B) Bridge, (T) Telephone, (C) DOCSIS Cable Device\n" +
                "  (W) WLAN Access Point, (P) Repeater, (S) Station, (O) Other\n" +
                "Device ID            Local Intf      Hold-time  Capability  Port ID\n" +
                "\n" +
                "Chassis id: 002a.6a4c.2721\n" +
                "Port id: mgmt0\n" +
                "Local Port id: mgmt0\n" +
                "Port Description: mgmt0\n" +
                "System Name: SH-YF-A-N5K-192.168.100.54-IP\n" +
                "System Description: Cisco Nexus Operating System (NX-OS) Software 7.0(5)N1(1)\n" +
                "TAC support: http://www.cisco.com/tac\n" +
                "Copyright (c) 2002-2014, Cisco Systems, Inc. All rights reserved.\n" +
                "Time remaining: 114 seconds\n" +
                "System Capabilities: B\n" +
                "Enabled Capabilities: B\n" +
                "Management Address: 192.168.254.3\n" +
                "Vlan ID: not advertised\n" +
                "\n" +
                "\n" +
                "Chassis id: 002a.6a4c.2730\n" +
                "Port id: Eth1/9\n" +
                "Local Port id: Eth1/9\n" +
                "Port Description: Ethernet1/9\n" +
                "System Name: SH-YF-A-N5K-192.168.100.54-IP\n" +
                "System Description: Cisco Nexus Operating System (NX-OS) Software 7.0(5)N1(1)\n" +
                "TAC support: http://www.cisco.com/tac\n" +
                "Copyright (c) 2002-2014, Cisco Systems, Inc. All rights reserved.\n" +
                "Time remaining: 114 seconds\n" +
                "System Capabilities: B\n" +
                "Enabled Capabilities: B\n" +
                "Management Address: 192.168.254.3\n" +
                "Vlan ID: 1\n" +
                "\n" +
                "\n" +
                "Chassis id: 002a.6a4c.2731\n" +
                "Port id: Eth1/10\n" +
                "Local Port id: Eth1/10\n" +
                "Port Description: Ethernet1/10\n" +
                "System Name: SH-YF-A-N5K-192.168.100.54-IP\n" +
                "System Description: Cisco Nexus Operating System (NX-OS) Software 7.0(5)N1(1)\n" +
                "TAC support: http://www.cisco.com/tac\n" +
                "Copyright (c) 2002-2014, Cisco Systems, Inc. All rights reserved.\n" +
                "Time remaining: 117 seconds\n" +
                "System Capabilities: B\n" +
                "Enabled Capabilities: B\n" +
                "Management Address: 192.168.254.3\n" +
                "Vlan ID: 1\n" +
                "\n" +
                "\n" +
                "Chassis id: 003a.9c3b.114c\n" +
                "Port id: Ethernet1/5\n" +
                "Local Port id: Eth1/27\n" +
                "Port Description: to 5K1_192.168.100.53(10GZ01)\n" +
                "System Name: SH-YF-R-N93180-192.168.100.66-I0\n" +
                "System Description: Cisco Nexus Operating System (NX-OS) Software 9.2(1)\n" +
                "TAC support: http://www.cisco.com/tac\n" +
                "Copyright (c) 2002-2018, Cisco Systems, Inc. All rights reserved.\n" +
                "Time remaining: 111 seconds\n" +
                "System Capabilities: B, R\n" +
                "Enabled Capabilities: B, R\n" +
                "Management Address: 003a.9c3b.114c\n" +
                "Vlan ID: not advertised\n" +
                "\n" +
                "\n" +
                "Chassis id: 002a.6a4c.2743\n" +
                "Port id: Eth1/28\n" +
                "Local Port id: Eth1/28\n" +
                "Port Description: Ethernet1/28\n" +
                "System Name: SH-YF-A-N5K-192.168.100.54-IP\n" +
                "System Description: Cisco Nexus Operating System (NX-OS) Software 7.0(5)N1(1)\n" +
                "TAC support: http://www.cisco.com/tac\n" +
                "Copyright (c) 2002-2014, Cisco Systems, Inc. All rights reserved.\n" +
                "Time remaining: 114 seconds\n" +
                "System Capabilities: B\n" +
                "Enabled Capabilities: B\n" +
                "Management Address: 192.168.254.3\n" +
                "Vlan ID: not advertised\n" +
                "\n" +
                "\n" +
                "Chassis id: 003a.9c3b.502c\n" +
                "Port id: Ethernet1/5\n" +
                "Local Port id: Eth1/29\n" +
                "Port Description: 5K1_192.168.100.53(10GZ01)\n" +
                "System Name: SH-YF-R-N93180-192.168.100.65-I0\n" +
                "System Description: Cisco Nexus Operating System (NX-OS) Software 9.2(1)\n" +
                "TAC support: http://www.cisco.com/tac\n" +
                "Copyright (c) 2002-2018, Cisco Systems, Inc. All rights reserved.\n" +
                "Time remaining: 96 seconds\n" +
                "System Capabilities: B, R\n" +
                "Enabled Capabilities: B, R\n" +
                "Management Address: 003a.9c3b.502c\n" +
                "Vlan ID: not advertised\n" +
                "\n" +
                "\n" +
                "Chassis id: 78aa.8237.73ab\n" +
                "Port id: M-GigabitEthernet0/0/0\n" +
                "Local Port id: Eth105/1/38\n" +
                "Port Description: M-GigabitEthernet0/0/0 Interface\n" +
                "System Name: SH-YF-IPMI-C-6800F-10.5.255.15\n" +
                "System Description: H3C Comware Platform Software, Software Version 7.1.070, Release 2612P02\n" +
                "H3C S6800-54HF\n" +
                "Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                "Time remaining: 114 seconds\n" +
                "System Capabilities: B, R\n" +
                "Enabled Capabilities: B, R\n" +
                "Management Address: 10.211.5.206\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 74d6.cb87.5b3c\n" +
                "Port id: M-GigabitEthernet0/0/0\n" +
                "Local Port id: Eth105/1/39\n" +
                "Port Description: M-GigabitEthernet0/0/0 Interface\n" +
                "System Name: SH-YF-SC-9820-10.5.255.11\n" +
                "System Description: H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "H3C S9820-64H\n" +
                "Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                "Time remaining: 107 seconds\n" +
                "System Capabilities: B, R\n" +
                "Enabled Capabilities: B, R\n" +
                "Management Address: 10.211.5.204\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 74d6.cb87.5434\n" +
                "Port id: M-GigabitEthernet0/0/0\n" +
                "Local Port id: Eth105/1/40\n" +
                "Port Description: M-GigabitEthernet0/0/0 Interface\n" +
                "System Name: SH-YF-SC-9820-10.5.255.12\n" +
                "System Description: H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "H3C S9820-64H\n" +
                "Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                "Time remaining: 94 seconds\n" +
                "System Capabilities: B, R\n" +
                "Enabled Capabilities: B, R\n" +
                "Management Address: 10.211.5.205\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 6893.20ae.c0b6\n" +
                "Port id: M-GigabitEthernet0/0/0\n" +
                "Local Port id: Eth105/1/43\n" +
                "Port Description: M-GigabitEthernet0/0/0 Interface\n" +
                "System Name: SH-YF-WAN-A-ISW-10.211.5.203\n" +
                "System Description: H3C Comware Platform Software, Software Version 7.1.070, Release 2612P02\n" +
                "H3C S6800-54HF\n" +
                "Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                "Time remaining: 103 seconds\n" +
                "System Capabilities: B, R\n" +
                "Enabled Capabilities: B, R\n" +
                "Management Address: 10.211.5.203\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 083a.3888.2080\n" +
                "Port id: GigabitEthernet1/0/0\n" +
                "Local Port id: Eth105/1/48\n" +
                "Port Description: GigabitEthernet1/0/0 Interface\n" +
                "System Name: IPS\n" +
                "System Description: H3C Comware Software. Software Version 7.1.064, Release 8504P41\n" +
                "H3C SecPath T5030\n" +
                "Copyright (c) 2004-2021 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                "Time remaining: 112 seconds\n" +
                "System Capabilities: B, R\n" +
                "Enabled Capabilities: B, R\n" +
                "Management Address: 10.5.230.4\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6b8b.699c\n" +
                "Port id: ac1f.6b8b.699c\n" +
                "Local Port id: Eth109/1/6\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 116 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bdc.1afe\n" +
                "Port id: ac1f.6bdc.1afe\n" +
                "Local Port id: Eth110/1/16\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 95 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0c.326a\n" +
                "Port id: 3cec.ef0c.326a\n" +
                "Local Port id: Eth110/1/17\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 99 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0c.32b8\n" +
                "Port id: 3cec.ef0c.32b8\n" +
                "Local Port id: Eth110/1/18\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 106 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0c.7ce4\n" +
                "Port id: 3cec.ef0c.7ce4\n" +
                "Local Port id: Eth110/1/19\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 105 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bf8.45c5\n" +
                "Port id: ac1f.6bf8.45c5\n" +
                "Local Port id: Eth110/1/20\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 97 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bdc.1aff\n" +
                "Port id: ac1f.6bdc.1aff\n" +
                "Local Port id: Eth110/1/22\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 117 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bdc.0fe7\n" +
                "Port id: ac1f.6bdc.0fe7\n" +
                "Local Port id: Eth110/1/23\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 91 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bf8.45c4\n" +
                "Port id: ac1f.6bf8.45c4\n" +
                "Local Port id: Eth112/1/20\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 93 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bdc.0fe6\n" +
                "Port id: ac1f.6bdc.0fe6\n" +
                "Local Port id: Eth112/1/23\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 100 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bdc.1276\n" +
                "Port id: ac1f.6bdc.1276\n" +
                "Local Port id: Eth112/1/30\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 117 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6bdc.1277\n" +
                "Port id: ac1f.6bdc.1277\n" +
                "Local Port id: Eth112/1/31\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 120 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 4cd9.8f2c.be1a\n" +
                "Port id: 4cd9.8f2c.be1a\n" +
                "Local Port id: Eth114/1/1\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.0.200.\n" +
                "System Description: fw_version:AFW_214.0.200.0\n" +
                "Time remaining: 99 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 4cd9.8f2c.be1a\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 4cd9.8f27.e464\n" +
                "Port id: 4cd9.8f27.e464\n" +
                "Local Port id: Eth114/1/6\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.0.166.\n" +
                "System Description: fw_version:AFW_214.0.166.0\n" +
                "Time remaining: 109 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 4cd9.8f27.e464\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 4cd9.8f2c.b800\n" +
                "Port id: 4cd9.8f2c.b800\n" +
                "Local Port id: Eth114/1/11\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.0.200.\n" +
                "System Description: fw_version:AFW_214.0.200.0\n" +
                "Time remaining: 116 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 4cd9.8f2c.b800\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.23b2\n" +
                "Port id: ac1f.6be2.23b2\n" +
                "Local Port id: Eth115/1/7\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 110 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.2412\n" +
                "Port id: ac1f.6be2.2412\n" +
                "Local Port id: Eth115/1/8\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 102 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.22d2\n" +
                "Port id: ac1f.6be2.22d2\n" +
                "Local Port id: Eth115/1/9\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 96 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.2392\n" +
                "Port id: ac1f.6be2.2392\n" +
                "Local Port id: Eth115/1/10\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 100 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.22ae\n" +
                "Port id: ac1f.6be2.22ae\n" +
                "Local Port id: Eth115/1/12\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 108 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.2414\n" +
                "Port id: ac1f.6be2.2414\n" +
                "Local Port id: Eth115/1/13\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 112 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.561c\n" +
                "Port id: ac1f.6be2.561c\n" +
                "Local Port id: Eth115/1/14\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 115 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.4252\n" +
                "Port id: ac1f.6be2.4252\n" +
                "Local Port id: Eth115/1/15\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 118 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.41d8\n" +
                "Port id: ac1f.6be2.41d8\n" +
                "Local Port id: Eth115/1/16\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 117 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.4190\n" +
                "Port id: ac1f.6be2.4190\n" +
                "Local Port id: Eth115/1/17\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 93 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.5636\n" +
                "Port id: ac1f.6be2.5636\n" +
                "Local Port id: Eth115/1/18\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 101 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.226e\n" +
                "Port id: ac1f.6be2.226e\n" +
                "Local Port id: Eth115/1/19\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 118 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.241a\n" +
                "Port id: ac1f.6be2.241a\n" +
                "Local Port id: Eth115/1/20\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 98 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: ac1f.6be2.23bc\n" +
                "Port id: ac1f.6be2.23bc\n" +
                "Local Port id: Eth115/1/30\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 92 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: b026.28e1.9080\n" +
                "Port id: b026.28e1.9080\n" +
                "Local Port id: Eth116/1/1\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 98 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: b026.28e1.9080\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: b026.28e1.9081\n" +
                "Port id: b026.28e1.9081\n" +
                "Local Port id: Eth116/1/2\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 100 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: b026.28e1.9081\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 2cea.7f49.612c\n" +
                "Port id: 2cea.7f49.612c\n" +
                "Local Port id: Eth116/1/3\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 112 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 2cea.7f49.612c\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 2cea.7f49.612b\n" +
                "Port id: 2cea.7f49.612b\n" +
                "Local Port id: Eth116/1/4\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 112 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 2cea.7f49.612b\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: b026.28e1.b390\n" +
                "Port id: b026.28e1.b390\n" +
                "Local Port id: Eth116/1/5\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 115 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: b026.28e1.b390\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: b026.28e1.b391\n" +
                "Port id: b026.28e1.b391\n" +
                "Local Port id: Eth116/1/6\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 117 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: b026.28e1.b391\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 2cea.7f49.59f4\n" +
                "Port id: 2cea.7f49.59f4\n" +
                "Local Port id: Eth116/1/7\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 112 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 2cea.7f49.59f4\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 2cea.7f49.59f5\n" +
                "Port id: 2cea.7f49.59f5\n" +
                "Local Port id: Eth116/1/8\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 112 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 2cea.7f49.59f5\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: b026.28e1.b860\n" +
                "Port id: b026.28e1.b860\n" +
                "Local Port id: Eth116/1/9\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 118 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: b026.28e1.b860\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: b026.28e1.b861\n" +
                "Port id: b026.28e1.b861\n" +
                "Local Port id: Eth116/1/10\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 90 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: b026.28e1.b861\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 2cea.7f49.5961\n" +
                "Port id: 2cea.7f49.5961\n" +
                "Local Port id: Eth116/1/11\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 113 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 2cea.7f49.5961\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 2cea.7f49.5962\n" +
                "Port id: 2cea.7f49.5962\n" +
                "Local Port id: Eth116/1/12\n" +
                "Port Description: NIC 1/10Gb BASE-TE\n" +
                "System Name: Broadcom Adv. Dual 10GBASE-T Ethernet fw_version:AFW_214.4.28.3\n" +
                "System Description: fw_version:AFW_214.4.28.3\n" +
                "Time remaining: 113 seconds\n" +
                "System Capabilities: S\n" +
                "Enabled Capabilities: S\n" +
                "Management Address: 2cea.7f49.5962\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.80ce\n" +
                "Port id: 3cec.ef0d.80ce\n" +
                "Local Port id: Eth116/1/13\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 109 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.80cf\n" +
                "Port id: 3cec.ef0d.80cf\n" +
                "Local Port id: Eth116/1/14\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 109 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.80f0\n" +
                "Port id: 3cec.ef0d.80f0\n" +
                "Local Port id: Eth116/1/15\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 96 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.80f1\n" +
                "Port id: 3cec.ef0d.80f1\n" +
                "Local Port id: Eth116/1/16\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 96 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.6476\n" +
                "Port id: 3cec.ef0d.6476\n" +
                "Local Port id: Eth116/1/17\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 118 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.6477\n" +
                "Port id: 3cec.ef0d.6477\n" +
                "Local Port id: Eth116/1/18\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 120 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.62d4\n" +
                "Port id: 3cec.ef0d.62d4\n" +
                "Local Port id: Eth116/1/19\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 102 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.62d5\n" +
                "Port id: 3cec.ef0d.62d5\n" +
                "Local Port id: Eth116/1/20\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 100 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.7f2a\n" +
                "Port id: 3cec.ef0d.7f2a\n" +
                "Local Port id: Eth116/1/21\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 96 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef0d.7f2b\n" +
                "Port id: 3cec.ef0d.7f2b\n" +
                "Local Port id: Eth116/1/22\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 107 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef01.18be\n" +
                "Port id: 3cec.ef01.18be\n" +
                "Local Port id: Eth116/1/25\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 109 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "\n" +
                "Chassis id: 3cec.ef01.18bf\n" +
                "Port id: 3cec.ef01.18bf\n" +
                "Local Port id: Eth116/1/26\n" +
                "Port Description: not advertised\n" +
                "System Name: not advertised\n" +
                "System Description: not advertised\n" +
                "Time remaining: 109 seconds\n" +
                "System Capabilities: not advertised\n" +
                "Enabled Capabilities: not advertised\n" +
                "Management Address: not advertised\n" +
                "Vlan ID: 0\n" +
                "\n" +
                "Total entries displayed: 64";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<LLDPNeighbor> lldpNeighborBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusLLDPNeiDetailProcessor());
        List<LLDPNeighbor> process = lldpNeighborBasicIterableProcessor.process();
        System.out.println(process);

    }

    @Test
    public void lldpParse(){
        String ciscoOutput = " sh lldp neighbors\n" +
                "Capability codes:\n" +
                "  (R) Router, (B) Bridge, (T) Telephone, (C) DOCSIS Cable Device\n" +
                "  (W) WLAN Access Point, (P) Repeater, (S) Station, (O) Other\n" +
                "Device ID            Local Intf      Hold-time  Capability  Port ID\n" +
                "okSZ-SJHL-C-N9336-192.168.100.110-IP\n" +
                "                     mgmt0           120        BR          mgmt0\n" +
                "okSZ-SJHL-A-N93108-10.111.5.3-IP\n" +
                "                     Eth1/1          120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.4-IP\n" +
                "                     Eth1/2          120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.5-IP\n" +
                "                     Eth1/3          120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-HW6720-10.111.5.7\n" +
                "                     Eth1/5          120        BR          40GE0/0/2\n" +
                "okSZ-SJHL-A-N93108-10.111.5.6-IP\n" +
                "                     Eth1/6          120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.8-IP\n" +
                "                     Eth1/7          120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.9-IP\n" +
                "                     Eth1/8          120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.10-IP\n" +
                "                     Eth1/9          120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.11-IP\n" +
                "                     Eth1/10         120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.12-IP\n" +
                "                     Eth1/11         120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.13-IP\n" +
                "                     Eth1/12         120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-N93108-10.111.5.14-IVA\n" +
                "                     Eth1/14         120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-A-6800F-10.111.5.17\n" +
                "                     Eth1/16         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-A-6800F-10.111.5.18\n" +
                "                     Eth1/17         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-A-6800T-10.111.5.19\n" +
                "                     Eth1/18         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-A-6800F-10.111.5.21\n" +
                "                     Eth1/20         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-A-6800T-10.111.5.22\n" +
                "                     Eth1/21         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-A-6800T-10.111.5.23\n" +
                "                     Eth1/22         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-A-6800T-10.111.5.23\n" +
                "                     Eth1/23         121        BR          HundredGigE2/0/49\n" +
                "okSZ-SJHL-A-6800T-10.111.5.25\n" +
                "                     Eth1/24         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-A-6800F-10.111.5.26\n" +
                "                     Eth1/25         121        BR          HundredGigE1/0/50\n" +
                "okSZ-SJHL-A-N93108-10.111.5.27-IP\n" +
                "                     Eth1/26         120        BR          Ethernet1/50\n" +
                "okSZ-SJHL-A-6800F-10.111.5.29\n" +
                "                     Eth1/27         121        BR          HundredGigE1/0/49\n" +
                "okSZ-SJHL-C-N9336-192.168.100.110-IP\n" +
                "                     Eth1/29         120        BR          Ethernet1/29\n" +
                "okSZ-SJHL-C-N9336-192.168.100.110-IP\n" +
                "                     Eth1/30         120        BR          Ethernet1/30\n" +
                "okSZ-SJHL-R-N9K-192.168.100.108-IP\n" +
                "                     Eth1/31         120        BR          Ethernet1/50\n" +
                "okSZ-SJHL-R-N9K-192.168.100.107-IP\n" +
                "                     Eth1/32         120        BR          Ethernet1/49\n" +
                "okSZ-SJHL-C-N9336-192.168.100.110-IP\n" +
                "                     Eth1/33         120        BR          Ethernet1/33\n" +
                "okSZ-SJHL-C-N9336-192.168.100.110-IP\n" +
                "                     Eth1/34         120        BR          Ethernet1/34\n" +
                "Total entries displayed: 30\n" +
                "SZ-SJHL-C-N9336-192.168.100.109-IP#";

        String h3cOutput = "disp lldp neighbor-information list\n" +
                "Chassis ID : * -- -- Nearest nontpmr bridge neighbor\n" +
                "             # -- -- Nearest customer bridge neighbor\n" +
                "             Default -- -- Nearest bridge neighbor\n" +
                "Local Interface Chassis ID      Port ID                    System Name\n" +
                "HGE1/0/1        fc60-9b5f-4650  HundredGigE1/0/49          SH-YF-A-6800T-10.5.251.68\n" +
                "HGE1/0/2        fc60-9b5f-4650  HundredGigE2/0/49          SH-YF-A-6800T-10.5.251.68\n" +
                "HGE1/0/3        fc60-9b5f-22b0  HundredGigE1/0/49          SH-YF-A-6800T-10.5.251.69\n" +
                "HGE1/0/4        fc60-9b5f-22b0  HundredGigE2/0/49          SH-YF-A-6800T-10.5.251.69\n" +
                "HGE1/0/5        fc60-9b57-59cd  HundredGigE1/0/49          SH-YF-A-6800T-10.5.251.70\n" +
                "HGE1/0/6        fc60-9b57-59cd  HundredGigE2/0/49          SH-YF-A-6800T-10.5.251.70\n" +
                "HGE1/0/59       74d6-cb87-5b3c  HundredGigE1/0/13          SH-YF-SC-9820-10.5.255.11\n" +
                "HGE1/0/60       74d6-cb87-5434  HundredGigE1/0/13          SH-YF-SC-9820-10.5.255.12\n" +
                "HGE1/0/62       6ce5-f771-4d71  HundredGigE2/0/62          SH-YF-C-9820-10.5.255.17-IP\n" +
                "HGE1/0/63       6ce5-f771-4d71  HundredGigE2/0/63          SH-YF-C-9820-10.5.255.17-IP\n" +
                "HGE1/0/64       6ce5-f771-4d71  HundredGigE2/0/64          SH-YF-C-9820-10.5.255.17-IP\n" +
                "HGE2/0/1        fc60-9b5f-4650  HundredGigE1/0/50          SH-YF-A-6800T-10.5.251.68\n" +
                "HGE2/0/2        fc60-9b5f-4650  HundredGigE2/0/50          SH-YF-A-6800T-10.5.251.68\n" +
                "HGE2/0/3        fc60-9b5f-22b0  HundredGigE1/0/50          SH-YF-A-6800T-10.5.251.69\n" +
                "HGE2/0/4        fc60-9b5f-22b0  HundredGigE2/0/50          SH-YF-A-6800T-10.5.251.69\n" +
                "HGE2/0/5        fc60-9b57-59cd  HundredGigE1/0/50          SH-YF-A-6800T-10.5.251.70\n" +
                "HGE2/0/6        fc60-9b57-59cd  HundredGigE2/0/50          SH-YF-A-6800T-10.5.251.70\n" +
                "HGE2/0/59       74d6-cb87-5b3c  HundredGigE1/0/14          SH-YF-SC-9820-10.5.255.11\n" +
                "HGE2/0/60       74d6-cb87-5434  HundredGigE1/0/14          SH-YF-SC-9820-10.5.255.12\n" +
                "HGE2/0/62       6ce5-f771-4d71  HundredGigE1/0/62          SH-YF-C-9820-10.5.255.17-IP\n" +
                "HGE2/0/63       6ce5-f771-4d71  HundredGigE1/0/63          SH-YF-C-9820-10.5.255.17-IP\n" +
                "HGE2/0/64       6ce5-f771-4d71  HundredGigE1/0/64          SH-YF-C-9820-10.5.255.17-IP\n" +
                "<SH-YF-C-9820-10.5.255.17-IP>";

        String type = "cisco";

        String patternString =
                "[A-Z]{2}-[A-Z]+-[A-Z]{1,2}-[\\da-zA-z]+-(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})[-A-Z\\d]*";

        Pattern compile = Pattern.compile(patternString);
        Matcher matcher;
        if(type.equals("cisco")){
            matcher = compile.matcher(ciscoOutput);
        }else{
            matcher = compile.matcher(h3cOutput);
        }
        HashSet lldpNeighbors = new HashSet<LLDPNeighbor>();
        while (matcher.find()){
            String neighborName = matcher.group(0);
//            if(neighborName.contains("#") || neighborName.contains(">")) continue;
            String neighborAdminIp = matcher.group(1);
            LLDPNeighbor lldpNeighbor = new LLDPNeighbor("", "", neighborName, "", neighborAdminIp);
            if(!lldpNeighbor.getNeighborName().equals("SH-YF-A-N93108-10.198.0.12-I0"))
                lldpNeighbors.add(lldpNeighbor);
        }
        System.out.println(lldpNeighbors);
        System.out.println("size is: " + lldpNeighbors.size());
    }

    @Test
    public void arpProcessorTest(){
        String output = " sh ip arp\n" +
                "\n" +
                "Flags: * - Adjacencies learnt on non-active FHRP router\n" +
                "       + - Adjacencies synced via CFSoE\n" +
                "       # - Adjacencies Throttled for Glean\n" +
                "       D - Static Adjacencies attached to down interface\n" +
                "\n" +
                "IP ARP Table for context default\n" +
                "Total number of entries: 1105\n" +
                "Address         Age       MAC Address     Interface\n" +
                "10.5.230.4      00:06:19  083a.3888.2084  Vlan230\n" +
                "10.5.230.29     00:05:37  0cc4.7ab9.14b6  Vlan230\n" +
                "10.5.230.30     00:05:36  0cc4.7ab9.15f7  Vlan230\n" +
                "10.5.230.31     00:02:48  6c92.bf85.f261  Vlan230\n" +
                "10.5.230.32     00:11:41  ac1f.6bc1.5650  Vlan230\n" +
                "10.5.230.33     00:02:52  6c92.bf89.bb2b  Vlan230\n" +
                "10.5.230.34     00:17:06  6c92.bfa6.9215  Vlan230\n" +
                "10.5.230.35     00:03:14  6c92.bf87.df5d  Vlan230\n" +
                "10.5.230.36     00:04:14  6c92.bf87.df47  Vlan230\n" +
                "10.5.230.37     00:03:40  6c92.bf87.df67  Vlan230\n" +
                "10.5.230.38     00:02:59  6c92.bf87.df63  Vlan230\n" +
                "10.5.230.39     00:03:47  6c92.bf87.df55  Vlan230\n" +
                "10.5.230.40     00:03:13  6c92.bf87.df51  Vlan230\n" +
                "10.5.230.41     00:03:11  6c92.bf87.df73  Vlan230\n" +
                "10.5.230.42     00:03:52  6c92.bf87.df5b  Vlan230\n" +
                "10.5.230.43     00:04:03  6c92.bf7e.c6b9  Vlan230\n" +
                "10.5.230.44     00:04:10  6c92.bf87.de53  Vlan230\n" +
                "10.5.230.46     00:03:33  6c92.bf87.df7b  Vlan230\n" +
                "10.5.230.47     00:02:49  6c92.bf87.df79  Vlan230\n" +
                "10.5.230.48     00:04:09  6c92.bf87.df9d  Vlan230\n" +
                "10.5.230.49     00:03:39  6c92.bf87.df6b  Vlan230\n" +
                "10.5.230.50     00:03:11  6c92.bf87.df75  Vlan230\n" +
                "10.5.230.51     00:03:29  6c92.bf87.df83  Vlan230\n" +
                "10.5.230.52     00:03:14  6c92.bf87.df8b  Vlan230\n" +
                "10.5.230.53     00:01:40  6c92.bf87.ded7  Vlan230\n" +
                "10.5.230.54     00:03:57  6c92.bf87.defb  Vlan230\n" +
                "10.5.230.55     00:00:09  6c92.bf87.deb7  Vlan230\n" +
                "10.5.230.56     00:03:16  6c92.bf87.dec1  Vlan230\n" +
                "10.5.230.57     00:02:52  6c92.bf87.e371  Vlan230\n" +
                "10.5.230.58     00:03:17  6c92.bf87.debb  Vlan230\n" +
                "10.5.230.59     00:04:05  6c92.bf87.deb3  Vlan230\n";
        ExpectResult expectResult = new ExpectResult(true, 0, "abc", output);
        BasicIterableProcessor<Arp> basicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusArpProcessor());
        List<Arp> process = basicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void parseMacTable() {
        String output = " sh mac address-table\n" +
                "Legend:\n" +
                "        * - primary entry, G - Gateway MAC, (R) - Routed MAC, O - Overlay MAC\n" +
                "        age - seconds since last seen,+ - primary entry using vPC Peer-Link,\n" +
                "        (T) - True, (F) - False, C - ControlPlane MAC, ~ - vsan\n" +
                "   VLAN     MAC Address      Type      age     Secure NTFY Ports\n" +
                "---------+-----------------+--------+---------+------+----+------------------\n" +
                "*    1     ac1f.6b9e.ffe2   dynamic  0         F      F    Po35\n" +
                "*  200     b07b.25da.d118   dynamic  0         F      F    Po1\n" +
                "*  200     b07b.25da.d32e   dynamic  0         F      F    Po1\n" +
                "*  200     b07b.25da.d39a   dynamic  0         F      F    Po1\n" +
                "*  200     b07b.25da.d3a6   dynamic  0         F      F    Po1\n" +
                "*  200     d4e8.8090.ae37   dynamic  0         F      F    Po1\n" +
                "*  200     f402.70c3.7f42   dynamic  0         F      F    Po1\n" +
                "*  329     0000.0c9f.f149   dynamic  0         F      F    Po1\n" +
                "*  329     00fd.22c1.daa7   dynamic  0         F      F    Po1\n" +
                "*  329     ac1f.6b0c.84c0   dynamic  0         F      F    Eth1/16\n" +
                "*  329     d4e8.8090.ae37   dynamic  0         F      F    Po1\n" +
                "*  600     0000.0c9f.f258   dynamic  0         F      F    Po1\n" +
                "*  600     d4e8.8090.ae37   dynamic  0         F      F    Po1\n" +
                "G    -     d4c9.3c32.633f   static   -         F      F    sup-eth1(R)\n" +
                "G  100     d4c9.3c32.633f   static   -         F      F    sup-eth1(R)\n" +
                "SH-YF-A-N93108-10.198.0.12-I0#";
        ExpectResult expectResult = new ExpectResult(true, 0, "abc", output);
        BasicIterableProcessor<MacEntry> basicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusMacTableProcessor());
        List<MacEntry> process = basicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void vlanNameProcessorTest(){
        String output = "SH-YF-A-N5K-192.168.100.53-IP# sh vlan\n" +
                "\n" +
                "VLAN Name                             Status    Ports\n" +
                "---- -------------------------------- --------- -------------------------------\n" +
                "1    default                          active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "5    test+Ztp                         active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211\n" +
                "30   SH_Res_Ser_10.5.30.0/23          active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211\n" +
                "32   SH_EPC_Ser_10.5.32.0/23          active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po206\n" +
                "                                                Po207, Po208, Po209, Po210\n" +
                "40   openstack_pxe_10.5.45.0/24       active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211\n" +
                "41   openstack_work_10.5.46.0/24      active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211\n" +
                "                                                Eth116/1/23" +
                "42   openstack_data_10.5.47.0/24      active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211\n" +
                "                                                Eth116/1/23\n" +
                "43   openstack_floating_10.5.48.0/20  active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211\n" +
                "                                                Eth116/1/23\n" +
                "64   openstack_floating_10.5.64.0/22  active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211\n" +
                "                                                Eth116/1/23\n" +
                "68   10.5.68.0/24_ceph_management     active    Po50, Po51, Po200, Po201, Po202\n" +
                "                                                Po203, Po204, Po205, Po207\n" +
                "                                                Po208, Po209, Po210, Po211";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<L2Vlan> l2VlanBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusVlanNameProcessor());
        List<L2Vlan> process = l2VlanBasicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void testBaseParserVlanDetail(){
        String output = "SH-YF-C-N5K-192.168.100.53-IP# sh ip inter vlan 580\n" +
                "IP Interface Status for VRF \"default\"(1)\n" +
                "Vlan580, Interface status: protocol-up/link-up/admin-up, iod: 771,\n" +
                "  IP address: 10.198.58.2, IP subnet: 10.198.58.0/26\n" +
                "  IP broadcast address: 255.255.255.255\n" +
                "  IP multicast groups locally joined:\n" +
                "      224.0.0.102\n" +
                "  IP MTU: 1500 bytes (using link MTU)\n" +
                "  IP primary address route-preference: 0, tag: 0\n" +
                "  IP proxy ARP : disabled\n" +
                "  IP Local Proxy ARP : disabled\n" +
                "  IP multicast routing: disabled\n" +
                "  IP icmp redirects: disabled\n" +
                "  IP directed-broadcast: disabled\n" +
                "  IP Forwarding: disabled\n" +
                "  IP icmp unreachables (except port): disabled\n" +
                "  IP icmp port-unreachable: enabled\n" +
                "  IP unicast reverse path forwarding: none\n" +
                "  IP load sharing: none\n" +
                "  IP interface statistics last reset: never\n" +
                "  IP interface software stats: (sent/received/forwarded/originated/consumed)\n" +
                "    Unicast packets    : 0/0/0/0/0\n" +
                "    Unicast bytes      : 0/0/0/0/0\n" +
                "    Multicast packets  : 1/670005/0/1/1340008\n" +
                "    Multicast bytes    : 82/53600384/0/82/53600320\n" +
                "    Broadcast packets  : 0/0/0/0/0\n" +
                "    Broadcast bytes    : 0/0/0/0/0\n" +
                "    Labeled packets    : 0/0/0/0/0\n" +
                "    Labeled bytes      : 0/0/0/0/0\n" +
                "  WCCP Redirect outbound: disabled\n" +
                "  WCCP Redirect inbound: disabled\n" +
                "  WCCP Redirect exclude: disabled\n" +
                "SH-YF-C-N5K-192.168.100.53-IP#\n";

        NexusVlanDetailProcessor nexusVlanDetailProcessor = new NexusVlanDetailProcessor();
        Segment generate = nexusVlanDetailProcessor.generate(output);
        System.out.println(generate);
    }

    @Test
    public void ipInterfaceBriefProcessor() {
        String output = " sh ip inter b\n" +
                "IP Interface Status for VRF \"default\"(1)\n" +
                "Interface            IP Address      Interface Status\n" +
                "Vlan5                10.211.5.2      protocol-up/link-up/admin-up\n" +
                "Vlan30               10.5.30.2       protocol-up/link-up/admin-up\n" +
                "Vlan32               10.5.32.2       protocol-up/link-up/admin-up\n" +
                "Vlan40               10.5.45.2       protocol-up/link-up/admin-up\n" +
                "Vlan41               10.5.46.2       protocol-up/link-up/admin-up\n" +
                "Vlan42               10.5.47.2       protocol-up/link-up/admin-up\n" +
                "Vlan43               10.5.48.2       protocol-up/link-up/admin-up\n" +
                "Vlan64               10.5.64.2       protocol-up/link-up/admin-up\n" +
                "Vlan68               10.5.68.2       protocol-up/link-up/admin-up\n" +
                "Vlan69               10.5.69.2       protocol-up/link-up/admin-up\n" +
                "Vlan104              10.211.104.2    protocol-up/link-up/admin-up\n" +
                "Vlan230              10.5.230.2      protocol-up/link-up/admin-up\n" +
                "Vlan241              10.211.41.2     protocol-up/link-up/admin-up\n" +
                "Vlan321              10.211.21.2     protocol-up/link-up/admin-up\n" +
                "Vlan580              10.198.58.2     protocol-up/link-up/admin-up\n" +
                "Lo0                  192.168.100.53  protocol-up/link-up/admin-up\n" +
                "Eth1/27              10.2.2.190      protocol-up/link-up/admin-up\n" +
                "Eth1/28              10.2.1.61       protocol-up/link-up/admin-up\n" +
                "Eth1/29              10.2.0.118      protocol-up/link-up/admin-up\n" +
                "SH-YF-A-N5K-192.168.100.53-IP#";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<Port> hashMapBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusIpInterfaceBriefProcessor());
        List<Port> process = hashMapBasicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void ciscoPortChannelNumsParserTest(){
        String output = "SH-YF-A-N93108-10.198.0.12-I0# sh port-channel summary\n" +
                "Flags:  D - Down        P - Up in port-channel (members)\n" +
                "        I - Individual  H - Hot-standby (LACP only)\n" +
                "        s - Suspended   r - Module-removed\n" +
                "        b - BFD Session Wait\n" +
                "        S - Switched    R - Routed\n" +
                "        U - Up (port-channel)\n" +
                "        p - Up in delay-lacp mode (member)\n" +
                "        M - Not in use. Min-links not met\n" +
                "--------------------------------------------------------------------------------\n" +
                "Group Port-       Type     Protocol  Member Ports\n" +
                "      Channel\n" +
                "--------------------------------------------------------------------------------\n" +
                "1     Po1(SU)     Eth      NONE      Eth1/49(P)   Eth1/50(P)\n" +
                "10    Po10(SU)    Eth      NONE      Eth1/1(P)    Eth1/2(P)\n" +
                "11    Po11(SU)    Eth      NONE      Eth1/3(P)    Eth1/4(P)\n" +
                "12    Po12(SU)    Eth      NONE      Eth1/5(P)    Eth1/6(P)\n" +
                "13    Po13(SU)    Eth      NONE      Eth1/7(P)    Eth1/8(P)\n" +
                "14    Po14(SD)    Eth      NONE      Eth1/9(D)    Eth1/10(D)\n" +
                "15    Po15(SU)    Eth      NONE      Eth1/11(P)   Eth1/12(P)\n" +
                "16    Po16(SU)    Eth      NONE      Eth1/13(P)   Eth1/14(P)\n" +
                "17    Po17(SD)    Eth      NONE      Eth1/15(D)\n" +
                "18    Po18(SD)    Eth      NONE      --\n" +
                "19    Po19(SD)    Eth      NONE      --\n" +
                "20    Po20(SD)    Eth      NONE      --\n" +
                "21    Po21(SU)    Eth      LACP      Eth1/23(P)   Eth1/24(P)\n" +
                "22    Po22(SU)    Eth      LACP      Eth1/25(P)   Eth1/26(P)\n" +
                "23    Po23(SU)    Eth      LACP      Eth1/27(P)   Eth1/28(P)\n" +
                "24    Po24(SU)    Eth      LACP      Eth1/29(P)   Eth1/30(P)\n" +
                "25    Po25(SU)    Eth      NONE      Eth1/31(P)   Eth1/32(P)\n" +
                "26    Po26(SU)    Eth      NONE      Eth1/33(P)   Eth1/34(P)\n" +
                "27    Po27(SU)    Eth      NONE      Eth1/35(P)   Eth1/36(P)\n" +
                "28    Po28(SU)    Eth      NONE      Eth1/37(P)   Eth1/38(P)\n" +
                "29    Po29(SU)    Eth      NONE      Eth1/39(P)   Eth1/40(P)\n" +
                "30    Po30(SU)    Eth      NONE      Eth1/41(P)   Eth1/42(P)\n" +
                "31    Po31(SD)    Eth      NONE      Eth1/43(D)   Eth1/44(D)\n" +
                "32    Po32(SD)    Eth      NONE      Eth1/45(D)   Eth1/46(D)\n" +
                "33    Po33(SU)    Eth      LACP      Eth1/47(P)   Eth1/48(P)\n" +
                "35    Po35(SU)    Eth      LACP      Eth1/19(P)   Eth1/20(P)\n" +
                "36    Po36(SU)    Eth      LACP      Eth1/21(P)   Eth1/22(P)\n" +
                "37    Po37(SD)    Eth      NONE      --\n" +
                "38    Po38(SD)    Eth      NONE      --\n" +
                "39    Po39(SD)    Eth      NONE      --\n" +
                "40    Po40(SD)    Eth      LACP      Eth1/17(s)\n" +
                "SH-YF-A-N93108-10.198.0.12-I0#";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<Integer> portChannelSummaryProcessor = new BasicIterableProcessor<>(expectResult, new NexusPortChannelSummaryProcessor());
        List<Integer> nums = portChannelSummaryProcessor.process();
        System.out.println(nums);
    }

    @Test
    public void testPortStatusProcessor(){
        String output = "SH-YF-A-N93108-10.198.0.12-I0# sh int status\n" +
                "\n" +
                "--------------------------------------------------------------------------------\n" +
                "Port          Name               Status    Vlan      Duplex  Speed   Type\n" +
                "--------------------------------------------------------------------------------\n" +
                "mgmt0         --                 disabled  routed    auto    auto    --\n" +
                "\n" +
                "--------------------------------------------------------------------------------\n" +
                "Port          Name               Status    Vlan      Duplex  Speed   Type\n" +
                "--------------------------------------------------------------------------------\n" +
                "Eth1/1        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/2        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/3        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/4        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/5        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/6        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/7        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/8        To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/9        To-plateform_hadoo notconnec 2         auto    auto    10g\n" +
                "Eth1/10       To-plateform_hadoo notconnec 2         auto    auto    10g\n" +
                "Eth1/11       To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/12       To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/13       To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/14       To-plateform_hadoo connected 2         full    10G     10g\n" +
                "Eth1/15       To-plateform_hadoo notconnec 2         auto    auto    10g\n" +
                "Eth1/16       --                 connected 329       full    10G     10g\n" +
                "Eth1/17       --                 connected 600       full    10G     10g\n" +
                "Eth1/18       --                 connected 2         full    10G     10g\n" +
                "Eth1/19       --                 connected trunk     full    10G     10g\n" +
                "Eth1/20       --                 connected trunk     full    10G     10g\n" +
                "Eth1/21       --                 connected trunk     full    10G     10g\n" +
                "Eth1/22       --                 connected trunk     full    10G     10g\n" +
                "Eth1/23       --                 connected trunk     full    10G     10g\n" +
                "Eth1/24       --                 connected trunk     full    10G     10g\n" +
                "Eth1/25       --                 connected trunk     full    10G     10g\n" +
                "Eth1/26       --                 connected trunk     full    10G     10g\n" +
                "Eth1/27       --                 connected trunk     full    10G     10g\n" +
                "Eth1/28       --                 connected trunk     full    10G     10g\n" +
                "Eth1/29       --                 connected trunk     full    10G     10g\n" +
                "Eth1/30       --                 connected trunk     full    10G     10g\n" +
                "Eth1/31       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/32       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/33       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/34       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/35       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/36       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/37       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/38       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/39       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/40       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/41       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/42       To_hadoop_10.198.2 connected 2         full    10G     10g\n" +
                "Eth1/43       To_hadoop_10.198.0 notconnec 100       auto    auto    10g\n" +
                "Eth1/44       To_hadoop_10.198.0 notconnec 100       auto    auto    10g\n" +
                "Eth1/45       To_hadoop_10.198.0 notconnec 100       auto    auto    10g\n" +
                "Eth1/46       To_hadoop_10.198.0 notconnec 100       auto    auto    10g\n" +
                "Eth1/47       To_hadoop_10.198.0 connected trunk     full    10G     10g\n" +
                "Eth1/48       To_hadoop_10.198.0 connected trunk     full    10G     10g\n" +
                "Eth1/49       To-uplink-192.168. connected trunk     full    40G     QSFP-40G-SR4\n" +
                "Eth1/50       To-uplink-192.168. connected trunk     full    40G     QSFP-40G-SR4\n" +
                "Eth1/51       --                 xcvrAbsen routed    auto    auto    --\n" +
                "Eth1/52       --                 xcvrAbsen routed    auto    auto    --\n" +
                "Eth1/53       --                 xcvrAbsen routed    auto    auto    --\n" +
                "Eth1/54       --                 xcvrAbsen routed    auto    auto    --\n" +
                "Po1           To-uplink-192.168. connected trunk     full    40G     --\n" +
                "Po10          To-plateform_hadoo connected 2         full    10G     --\n" +
                "Po11          To-plateform_hadoo connected 2         full    10G     --\n" +
                "Po12          To-plateform_hadoo connected 2         full    10G     --\n" +
                "Po13          To-plateform_hadoo connected 2         full    10G     --\n" +
                "Po14          To-plateform_hadoo noOperMem 2         full    auto    --\n" +
                "Po15          To-plateform_hadoo connected 2         full    10G     --\n" +
                "Po16          To-plateform_hadoo connected 2         full    10G     --\n" +
                "Po17          To-plateform_hadoo noOperMem 2         full    auto    --\n" +
                "Po18          To-plateform_hadoo noOperMem 2         full    auto    --\n" +
                "Po19          To_10.198.19.47    noOperMem trunk     full    auto    --\n" +
                "Po20          To_10.198.19.48    noOperMem trunk     full    auto    --\n" +
                "Po21          To_10.198.19.49    connected trunk     full    10G     --\n" +
                "Po22          To_10.198.19.50    connected trunk     full    10G     --\n" +
                "Po23          To_10.198.19.51    connected trunk     full    10G     --\n" +
                "Po24          To_10.198.19.52    connected trunk     full    10G     --\n" +
                "Po25          To_hadoop_10.198.2 connected 2         full    10G     --\n" +
                "Po26          To_hadoop_10.198.2 connected 2         full    10G     --\n" +
                "Po27          To_hadoop_10.198.2 connected 2         full    10G     --\n" +
                "Po28          To_hadoop_10.198.2 connected 2         full    10G     --\n" +
                "Po29          To_hadoop_10.198.2 connected 2         full    10G     --\n" +
                "Po30          To_hadoop_10.198.2 connected 2         full    10G     --\n" +
                "Po31          To_hadoop_10.198.0 noOperMem 100       full    auto    --\n" +
                "Po32          To_hadoop_10.198.0 noOperMem 100       full    auto    --\n" +
                "Po33          To_hadoop_10.198.0 connected trunk     full    10G     --\n" +
                "Po35          to_10.198.40.59    connected trunk     full    10G     --\n" +
                "Po36          to_10.198.40.63    connected trunk     full    10G     --\n" +
                "Vlan1         --                 down      routed    auto    auto    --\n" +
                "Vlan100       --                 connected routed    auto    auto    --\n" +
                "\n" +
                "--------------------------------------------------------------------------------\n" +
                "Port          Name               Status    Vlan      Duplex  Speed   Type\n" +
                "--------------------------------------------------------------------------------\n" +
                "SH-YF-A-N93108-10.198.0.12-I0#";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<PortStatus> portBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new NexusPortStatusProcessor());
        List<PortStatus> ports = portBasicIterableProcessor.process();
        System.out.println(ports);
    }

    @Test
    public void testPrompt(){
        String patternStr = "(\\S+)[]]";
        Pattern p = Pattern.compile(patternStr);
        String prompt = "[aba123-_1.1.1.1]";
        Matcher matcher = p.matcher(prompt);
        if (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }

    }
}
