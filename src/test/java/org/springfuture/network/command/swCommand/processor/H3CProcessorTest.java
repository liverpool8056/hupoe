package org.springfuture.network.command.swCommand.processor;

import org.junit.Test;
import org.springfuture.network.bean.*;
import org.springfuture.network.device.SwitchDevice;
import org.springfuture.network.ssh.ExpectResult;

import java.util.List;

public class H3CProcessorTest {

    @Test
    public void lldpProcessorTest(){
        String output = "<SH-YF-C-9820-10.5.255.17>disp lldp neighbor-information verbose\n" +
                "LLDP neighbor-information of port 1[HundredGigE1/0/1]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 36 minutes, 21 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-4650\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/49\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H1/0/1\n" +
                " System name         : SH-YF-A-6800T-10.5.251.68\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.68\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1619\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 6[HundredGigE1/0/2]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 36 minutes, 31 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-4650\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/49\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H1/0/2\n" +
                " System name         : SH-YF-A-6800T-10.5.251.68\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.68\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1619\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 7[HundredGigE1/0/3]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 37 minutes, 14 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-22b0\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/49\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H1/0/3\n" +
                " System name         : SH-YF-A-6800T-10.5.251.69\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.69\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 12[HundredGigE1/0/4]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 37 minutes, 17 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-22b0\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/49\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H1/0/4\n" +
                " System name         : SH-YF-A-6800T-10.5.251.69\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.69\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 13[HundredGigE1/0/5]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 49 minutes, 36 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b57-59cd\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/49\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H1/0/5\n" +
                " System name         : SH-YF-A-6800T-10.5.251.70\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.70\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1619\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 18[HundredGigE1/0/6]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 49 minutes, 41 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b57-59cd\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/49\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H1/0/6\n" +
                " System name         : SH-YF-A-6800T-10.5.251.70\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.70\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1619\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 175[HundredGigE1/0/59]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 4 minutes, 23 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 74d6-cb87-5b3c\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/13\n" +
                " Time to live        : 121\n" +
                " Port description    : To_SH-YF-C-10.5.255.17_H1/0/59\n" +
                " System name         : SH-YF-SC-9820-10.5.255.11\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.253.105\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 37\n" +
                " Management address OID            : 0\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : No\n" +
                " Aggregation port ID        : 0\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 9416\n" +
                "\n" +
                "LLDP neighbor-information of port 180[HundredGigE1/0/60]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 338 days, 12 hours, 48 minutes, 15 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 74d6-cb87-5434\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/13\n" +
                " Time to live        : 121\n" +
                " Port description    : To_SH-YF-C-10.5.255.17_H1/0/60\n" +
                " System name         : SH-YF-SC-9820-10.5.255.12\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.253.133\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 37\n" +
                " Management address OID            : 0\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : No\n" +
                " Aggregation port ID        : 0\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 9416\n" +
                "\n" +
                "LLDP neighbor-information of port 186[HundredGigE1/0/62]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 34 minutes, 14 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 6ce5-f771-4d71\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/62\n" +
                " Time to live        : 121\n" +
                " Port description    : stack_port\n" +
                " System name         : SH-YF-C-9820-10.5.255.17\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 1.1.1.5\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 2152\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 3000\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : No\n" +
                " Aggregation port ID        : 0\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 9416\n" +
                "\n" +
                "LLDP neighbor-information of port 187[HundredGigE1/0/63]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 27 minutes, 16 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 6ce5-f771-4d71\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/63\n" +
                " Time to live        : 121\n" +
                " Port description    : stack_port\n" +
                " System name         : SH-YF-C-9820-10.5.255.17\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                "\n" +
                "LLDP neighbor-information of port 192[HundredGigE1/0/64]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 27 minutes, 16 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 6ce5-f771-4d71\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/64\n" +
                " Time to live        : 121\n" +
                " Port description    : stack_port\n" +
                " System name         : SH-YF-C-9820-10.5.255.17\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                "\n" +
                "LLDP neighbor-information of port 196[HundredGigE2/0/1]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 36 minutes, 23 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-4650\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/50\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H2/0/1\n" +
                " System name         : SH-YF-A-6800T-10.5.251.68\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.68\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1619\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 201[HundredGigE2/0/2]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 36 minutes, 32 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-4650\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/50\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H2/0/2\n" +
                " System name         : SH-YF-A-6800T-10.5.251.68\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.68\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1619\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 202[HundredGigE2/0/3]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 37 minutes, 13 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-22b0\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/50\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H2/0/3\n" +
                " System name         : SH-YF-A-6800T-10.5.251.69\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.69\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 207[HundredGigE2/0/4]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 37 minutes, 24 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b5f-22b0\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/50\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H2/0/4\n" +
                " System name         : SH-YF-A-6800T-10.5.251.69\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.69\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1621\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 208[HundredGigE2/0/5]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 49 minutes, 36 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b57-59cd\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/50\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H2/0/5\n" +
                " System name         : SH-YF-A-6800T-10.5.251.70\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.70\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1619\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 213[HundredGigE2/0/6]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 49 minutes, 47 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : fc60-9b57-59cd\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE2/0/50\n" +
                " Time to live        : 121\n" +
                " Port description    : SH-YF-C-9820-10.5.255.17_H2/0/6\n" +
                " System name         : SH-YF-A-6800T-10.5.251.70\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 2612P01\n" +
                "   H3C S6800-54HT\n" +
                "   Copyright (c) 2004-2018 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.251.70\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 1620\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 1\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : Yes\n" +
                " Aggregation port ID        : 1619\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 10000\n" +
                "\n" +
                "LLDP neighbor-information of port 370[HundredGigE2/0/59]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 165 days, 13 hours, 17 minutes, 31 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 74d6-cb87-5b3c\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/14\n" +
                " Time to live        : 121\n" +
                " Port description    : To_SH-YF-C-10.5.255.17_H2/0/59\n" +
                " System name         : SH-YF-SC-9820-10.5.255.11\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.253.109\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 42\n" +
                " Management address OID            : 0\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : No\n" +
                " Aggregation port ID        : 0\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 9416\n" +
                "\n" +
                "LLDP neighbor-information of port 375[HundredGigE2/0/60]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 137 days, 3 hours, 4 minutes, 43 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 74d6-cb87-5434\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/14\n" +
                " Time to live        : 121\n" +
                " Port description    : To_SH-YF-C-10.5.255.17_H2/0/60\n" +
                " System name         : SH-YF-SC-9820-10.5.255.12\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 10.5.253.137\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 42\n" +
                " Management address OID            : 0\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : No\n" +
                " Aggregation port ID        : 0\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 9416\n" +
                "\n" +
                "LLDP neighbor-information of port 381[HundredGigE2/0/62]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 34 minutes, 3 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 6ce5-f771-4d71\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/62\n" +
                " Time to live        : 121\n" +
                " Port description    : stack_port\n" +
                " System name         : SH-YF-C-9820-10.5.255.17\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                " Management address type           : IPv4\n" +
                " Management address                : 1.1.1.5\n" +
                " Management address interface type : IfIndex\n" +
                " Management address interface ID   : 2152\n" +
                " Management address OID            : 0\n" +
                " Port VLAN ID(PVID)  : 3000\n" +
                " Link aggregation supported : Yes\n" +
                " Link aggregation enabled   : No\n" +
                " Aggregation port ID        : 0\n" +
                " Auto-negotiation supported : Yes\n" +
                " Auto-negotiation enabled   : Yes\n" +
                " OperMau                    : Speed(100000)/Duplex(Full)\n" +
                " Power port class           : PD\n" +
                " PSE power supported        : No\n" +
                " PSE power enabled          : No\n" +
                " PSE pairs control ability  : No\n" +
                " Power pairs                : Signal\n" +
                " Port power classification  : Class 0\n" +
                " Maximum frame size         : 9416\n" +
                "\n" +
                "LLDP neighbor-information of port 382[HundredGigE2/0/63]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 27 minutes, 18 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 6ce5-f771-4d71\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/63\n" +
                " Time to live        : 121\n" +
                " Port description    : stack_port\n" +
                " System name         : SH-YF-C-9820-10.5.255.17\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                "\n" +
                "LLDP neighbor-information of port 387[HundredGigE2/0/64]:\n" +
                "LLDP agent nearest-bridge:\n" +
                " LLDP neighbor index : 1\n" +
                " Update time         : 0 days, 0 hours, 27 minutes, 16 seconds\n" +
                " Chassis type        : MAC address\n" +
                " Chassis ID          : 6ce5-f771-4d71\n" +
                " Port ID type        : Interface name\n" +
                " Port ID             : HundredGigE1/0/64\n" +
                " Time to live        : 121\n" +
                " Port description    : stack_port\n" +
                " System name         : SH-YF-C-9820-10.5.255.17\n" +
                " System description  :\n" +
                "   H3C Comware Platform Software, Software Version 7.1.070, Release 6555P01\n" +
                "   H3C S9820-64H\n" +
                "   Copyright (c) 2004-2019 New H3C Technologies Co., Ltd. All rights reserved.\n" +
                " System capabilities supported : Bridge, Router, Customer Bridge, Service Bridge\n" +
                " System capabilities enabled   : Bridge, Router, Customer Bridge\n" +
                "\n" +
                "<SH-YF-C-9820-10.5.255.17>";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<LLDPNeighbor> lldpNeighborBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new H3CLLDPNeiDetailProcessor());
        List<LLDPNeighbor> process = lldpNeighborBasicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void arpListProcessorTest() {
        String output = "disp arp all\n" +
                "  Type: S-Static   D-Dynamic   O-Openflow   R-Rule   M-Multiport  I-Invalid\n" +
                "IP address      MAC address    VLAN/VSI   Interface                Aging Type\n" +
                "10.5.253.105    74d6-cb87-5b6d --         HGE1/0/59                119   D\n" +
                "10.5.251.68     fc60-9b5f-4674 251        BAGG1                    1053  D\n" +
                "10.198.32.60    3cec-ef1f-e47e 32         BAGG1                    557   D\n" +
                "10.198.32.63    8061-5f0b-cb72 32         BAGG1                    557   D\n" +
                "10.198.32.64    8061-5f03-402c 32         BAGG1                    557   D\n" +
                "10.198.32.65    8061-5f03-4032 32         BAGG1                    557   D\n" +
                "10.198.32.66    8061-5f03-3fca 32         BAGG1                    1185  D\n" +
                "10.198.32.67    8061-5f03-407e 32         BAGG1                    557   D\n" +
                "10.198.32.68    8061-5f0b-cba4 32         BAGG1                    557   D\n" +
                "10.198.32.69    8061-5f03-4036 32         BAGG1                    557   D\n" +
                "10.198.32.70    8061-5f0b-cba2 32         BAGG1                    563   D\n" +
                "10.198.32.71    8061-5f0b-cb9c 32         BAGG1                    563   D\n" +
                "10.198.32.72    bc97-e153-1c06 32         BAGG1                    566   D\n" +
                "10.198.32.73    ac1f-6bbb-8f84 32         BAGG1                    1197  D\n" +
                "10.198.32.74    ac1f-6bbb-903a 32         BAGG1                    557   D\n" +
                "10.198.32.75    ac1f-6b3a-1140 32         BAGG1                    1184  D\n" +
                "10.198.32.100   ac1f-6bea-cb2e 32         BAGG1                    745   D\n" +
                "10.198.32.101   ac1f-6bdd-c04c 32         BAGG1                    671   D\n" +
                "10.198.32.102   ac1f-6bea-c97e 32         BAGG1                    557   D\n" +
                "10.198.32.103   ac1f-6bea-c932 32         BAGG1                    566   D\n" +
                "10.198.32.104   3cec-ef1c-3db2 32         BAGG1                    557   D\n" +
                "10.198.32.105   3cec-ef1c-3e5e 32         BAGG1                    557   D\n" +
                "10.198.32.106   3cec-ef1c-3f98 32         BAGG1                    557   D\n" +
                "10.198.32.107   3cec-ef1b-50ae 32         BAGG1                    578   D\n" +
                "10.198.32.108   3cec-ef1c-3f9a 32         BAGG1                    557   D\n" +
                "10.198.32.109   3cec-ef1c-3e58 32         BAGG1                    563   D\n" +
                "10.198.32.110   ac1f-6bea-cb10 32         BAGG1                    563   D\n" +
                "10.198.32.111   ac1f-6bea-c94e 32         BAGG1                    557   D\n" +
                "10.198.32.112   ac1f-6bea-cb42 32         BAGG1                    563   D\n" +
                "10.198.32.113   ac1f-6bea-cacc 32         BAGG1                    557   D\n" +
                "10.198.32.118   ac1f-6bea-cada 32         BAGG1                    557   D\n" +
                "10.198.32.119   ac1f-6bea-cace 32         BAGG1                    557   D\n" +
                "10.198.32.120   ac1f-6bea-c9b4 32         BAGG1                    557   D\n" +
                "10.198.32.121   ac1f-6bea-c9c0 32         BAGG1                    557   D\n" +
                "10.198.32.122   ac1f-6bea-c938 32         BAGG1                    557   D\n" +
                "10.198.32.123   ac1f-6bea-ca8a 32         BAGG1                    557   D\n" +
                "10.198.32.124   ac1f-6bc8-d752 32         BAGG1                    557   D\n" +
                "10.198.32.125   ac1f-6bc8-6060 32         BAGG1                    557   D\n" +
                "10.198.32.126   ac1f-6bc8-6168 32         BAGG1                    557   D\n" +
                "10.198.32.127   ac1f-6bc8-d74e 32         BAGG1                    557   D\n" +
                "10.198.32.128   ac1f-6bc8-6164 32         BAGG1                    557   D\n" +
                "10.198.32.129   ac1f-6bc8-61ac 32         BAGG1                    557   D\n" +
                "10.198.32.130   ac1f-6bc8-63f0 32         BAGG1                    557   D\n" +
                "10.198.32.131   ac1f-6bc8-d8c6 32         BAGG1                    557   D\n" +
                "10.198.32.132   ac1f-6bc8-624c 32         BAGG1                    557   D\n" +
                "10.198.32.133   ac1f-6bc8-6388 32         BAGG1                    557   D\n" +
                "10.198.32.134   ac1f-6bea-ca9e 32         BAGG1                    557   D\n" +
                "10.198.32.135   ac1f-6beb-bcd8 32         BAGG1                    557   D\n" +
                "10.198.32.136   ac1f-6bea-c97c 32         BAGG1                    557   D\n" +
                "10.198.32.137   ac1f-6beb-bca6 32         BAGG1                    557   D\n" +
                "10.198.32.138   ac1f-6bea-cb1e 32         BAGG1                    557   D\n" +
                "10.198.32.252   8061-5f0b-cb72 32         BAGG1                    557   D\n" +
                "10.198.32.254   ac1f-6beb-bca6 32         BAGG1                    557   D\n" +
                "10.5.251.69     fc60-9b5f-22d4 251        BAGG2                    1056  D\n" +
                "10.198.32.11    e861-1f29-d4bd 32         BAGG2                    1200  D\n" +
                "10.198.32.12    e861-1f29-d449 32         BAGG2                    1200  D\n" +
                "10.198.32.13    e861-1f29-cd77 32         BAGG2                    1200  D\n" +
                "10.198.32.14    e861-1f2b-22d3 32         BAGG2                    557   D\n" +
                "10.198.32.15    e861-1f29-d4af 32         BAGG2                    557   D\n" +
                "10.198.32.16    e861-1f29-cd89 32         BAGG2                    557   D\n" +
                "10.198.32.17    e861-1f29-d2b9 32         BAGG2                    557   D\n" +
                "10.198.32.18    e861-1f29-d767 32         BAGG2                    557   D\n" +
                "10.198.32.19    e861-1f29-d3a9 32         BAGG2                    557   D\n" +
                "10.198.32.20    e861-1f29-d67f 32         BAGG2                    557   D\n" +
                "10.198.32.21    e861-1f29-d789 32         BAGG2                    557   D\n" +
                "10.198.32.22    e861-1f29-d78f 32         BAGG2                    557   D\n" +
                "10.198.32.23    e861-1f29-d4bf 32         BAGG2                    563   D\n" +
                "10.198.32.24    e861-1f29-d4f7 32         BAGG2                    557   D\n" +
                "10.198.32.25    e861-1f29-d7d5 32         BAGG2                    557   D\n" +
                "10.198.32.26    e861-1f29-d731 32         BAGG2                    557   D\n" +
                "10.198.32.27    e861-1f29-d79d 32         BAGG2                    557   D\n" +
                "10.198.32.28    e861-1f29-d7b7 32         BAGG2                    557   D\n" +
                "10.198.32.29    e861-1f29-d65d 32         BAGG2                    557   D\n" +
                "10.198.32.30    e861-1f29-d4bb 32         BAGG2                    557   D\n" +
                "10.198.32.31    e861-1f29-d73d 32         BAGG2                    557   D\n" +
                "10.198.32.32    e861-1f29-d78b 32         BAGG2                    557   D\n" +
                "10.198.32.33    e861-1f29-d26d 32         BAGG2                    557   D\n" +
                "10.198.32.34    e861-1f29-d787 32         BAGG2                    557   D\n" +
                "10.5.251.70     fc60-9b57-59f1 251        BAGG3                    1056  D\n" +
                "10.198.32.35    e861-1f29-d5f1 32         BAGG3                    1189  D\n" +
                "10.198.32.36    e861-1f29-d79b 32         BAGG3                    557   D\n" +
                "10.198.32.37    e861-1f29-d30f 32         BAGG3                    557   D\n" +
                "10.198.32.38    e861-1f29-d347 32         BAGG3                    557   D\n" +
                "10.198.32.39    e861-1f29-d751 32         BAGG3                    557   D\n" +
                "10.198.32.40    e861-1f29-cdef 32         BAGG3                    557   D\n" +
                "10.198.32.41    e861-1f29-d2ed 32         BAGG3                    557   D\n" +
                "10.198.32.42    e861-1f29-d297 32         BAGG3                    557   D\n" +
                "10.198.32.43    e861-1f29-d32d 32         BAGG3                    1200  D\n" +
                "10.198.32.44    e861-1f2b-24dd 32         BAGG3                    1192  D\n" +
                "10.198.32.45    e861-1f29-db03 32         BAGG3                    1195  D\n" +
                "10.198.32.46    e861-1f2b-2711 32         BAGG3                    573   D\n" +
                "10.198.32.47    e861-1f29-d8a9 32         BAGG3                    557   D\n" +
                "10.198.32.48    e861-1f29-d34d 32         BAGG3                    557   D\n" +
                "10.198.32.49    e861-1f29-d345 32         BAGG3                    557   D\n" +
                "10.198.32.50    e861-1f29-d975 32         BAGG3                    557   D\n" +
                "10.198.32.51    e861-1f29-d497 32         BAGG3                    557   D\n" +
                "10.198.32.52    e861-1f29-ce5f 32         BAGG3                    557   D\n" +
                "10.198.32.53    e861-1f2b-276b 32         BAGG3                    557   D\n" +
                "10.198.32.54    e861-1f29-d909 32         BAGG3                    557   D\n" +
                "10.198.32.55    e861-1f29-d4a3 32         BAGG3                    557   D\n" +
                "10.198.32.56    3cec-ef1f-e48a 32         BAGG3                    1200  D\n" +
                "10.198.32.57    3cec-ef1f-e416 32         BAGG3                    1200  D\n" +
                "10.198.32.58    3cec-ef1f-e47a 32         BAGG3                    1200  D\n" +
                "10.198.32.59    3cec-ef1f-e480 32         BAGG3                    560   D\n" +
                "10.198.32.61    b496-915c-9874 32         BAGG3                    560   D\n" +
                "10.198.32.62    b496-9105-4454 32         BAGG3                    560   D\n" +
                "10.198.32.76    bc97-e153-1bbe 32         BAGG3                    560   D\n" +
                "10.198.32.77    6c92-bfe5-ab88 32         BAGG3                    969   D\n" +
                "10.198.32.78    6c92-bfe4-7708 32         BAGG3                    1168  D\n" +
                "10.5.253.133    74d6-cb87-5465 --         HGE1/0/60                1200  D\n" +
                "10.5.253.137    74d6-cb87-5465 --         HGE2/0/60                1069  D\n" +
                "10.5.253.109    74d6-cb87-5b6d --         HGE2/0/59                940   D\n" +
                "<SH-YF-C-9820-10.5.255.17>";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        SwitchDevice switchDevice = new SwitchDevice();
        switchDevice.setIp("1.1.1.1");
        BasicIterableProcessor<Arp> arpBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new H3CArpProcessor(switchDevice));
        List<Arp> process = arpBasicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void parseMacTable() {
        String output = "disp mac-address\n" +
                "MAC Address      VLAN ID    State            Port/Nickname            Aging\n" +
                "3cec-ef1f-e416   32         Learned          XGE1/0/2                 Y\n" +
                "3cec-ef1f-e47a   32         Learned          XGE1/0/3                 Y\n" +
                "3cec-ef1f-e480   32         Learned          XGE1/0/4                 Y\n" +
                "3cec-ef1f-e48a   32         Learned          XGE1/0/1                 Y\n" +
                "6ce5-f771-4d83   32         Learned          BAGG100                  Y\n" +
                "8061-5f03-3fca   32         Learned          BAGG100                  Y\n" +
                "8061-5f03-402c   32         Learned          BAGG100                  Y\n" +
                "8061-5f03-4032   32         Learned          BAGG100                  Y\n" +
                "8061-5f03-4036   32         Learned          BAGG100                  Y\n" +
                "8061-5f03-407e   32         Learned          BAGG100                  Y\n" +
                "8061-5f0b-cb72   32         Learned          BAGG100                  Y\n" +
                "8061-5f0b-cba2   32         Learned          BAGG100                  Y\n" +
                "8061-5f0b-cba4   32         Learned          BAGG100                  Y\n" +
                "ac1f-6bbb-8f84   32         Learned          BAGG100                  Y\n" +
                "ac1f-6bbb-903a   32         Learned          BAGG100                  Y\n" +
                "ac1f-6beb-bca6   32         Learned          BAGG100                  Y\n" +
                "b496-9105-4454   32         Learned          XGE1/0/26                Y\n" +
                "b496-915c-9876   32         Learned          XGE1/0/27                Y\n" +
                "bc97-e153-1c06   32         Learned          BAGG100                  Y\n" +
                "e861-1f29-cd77   32         Learned          BAGG100                  Y\n" +
                "e861-1f29-cdef   32         Learned          XGE1/0/10                Y\n" +
                "e861-1f29-ce5f   32         Learned          XGE1/0/22                Y\n" +
                "e861-1f29-d297   32         Learned          XGE1/0/12                Y\n" +
                "e861-1f29-d2ed   32         Learned          XGE1/0/11                Y\n" +
                "e861-1f29-d30f   32         Learned          XGE1/0/7                 Y\n" +
                "e861-1f29-d32d   32         Learned          XGE1/0/13                Y\n" +
                "e861-1f29-d345   32         Learned          XGE1/0/19                Y\n" +
                "e861-1f29-d347   32         Learned          XGE1/0/8                 Y\n" +
                "e861-1f29-d34d   32         Learned          XGE1/0/18                Y\n" +
                "e861-1f29-d449   32         Learned          BAGG100                  Y\n" +
                "e861-1f29-d497   32         Learned          XGE1/0/21                Y\n" +
                "e861-1f29-d4a3   32         Learned          XGE1/0/25                Y\n" +
                "e861-1f29-d4bd   32         Learned          BAGG100                  Y\n" +
                "e861-1f29-d5f1   32         Learned          XGE1/0/5                 Y\n" +
                "e861-1f29-d751   32         Learned          XGE1/0/9                 Y\n" +
                "e861-1f29-d789   32         Learned          BAGG100                  Y\n" +
                "e861-1f29-d79b   32         Learned          XGE1/0/6                 Y\n" +
                "e861-1f29-d8a9   32         Learned          XGE1/0/17                Y\n" +
                "e861-1f29-d909   32         Learned          XGE1/0/24                Y\n" +
                "e861-1f29-d975   32         Learned          XGE1/0/20                Y\n" +
                "e861-1f29-db03   32         Learned          XGE1/0/15                Y\n" +
                "e861-1f2b-24dd   32         Learned          XGE1/0/14                Y\n" +
                "e861-1f2b-2711   32         Learned          XGE1/0/16                Y\n" +
                "e861-1f2b-276b   32         Learned          XGE1/0/23                Y\n" +
                "6ce5-f771-4d9e   251        Learned          BAGG100                  Y\n" +
                "6ce5-f771-4d89   582        Learned          BAGG100                  Y\n" +
                "3cec-ef1f-e417   32         Learned          XGE2/0/2                 Y\n" +
                "3cec-ef1f-e47b   32         Learned          XGE2/0/3                 Y\n" +
                "3cec-ef1f-e481   32         Learned          XGE2/0/4                 Y\n" +
                "3cec-ef1f-e48b   32         Learned          XGE2/0/1                 Y\n" +
                "6c92-bfe4-7708   32         Learned          XGE2/0/30                Y\n" +
                "6c92-bfe5-ab88   32         Learned          XGE2/0/29                Y\n" +
                "b496-9105-4456   32         Learned          XGE2/0/26                Y\n" +
                "b496-915c-9874   32         Learned          XGE2/0/27                Y\n" +
                "bc97-e153-1bbe   32         Learned          XGE2/0/28                Y\n" +
                "e861-1f29-cdef   32         Learned          XGE2/0/10                Y\n" +
                "e861-1f29-ce5f   32         Learned          XGE2/0/22                Y\n" +
                "e861-1f29-d297   32         Learned          XGE2/0/12                Y\n" +
                "e861-1f29-d2ed   32         Learned          XGE2/0/11                Y\n" +
                "e861-1f29-d30f   32         Learned          XGE2/0/7                 Y\n" +
                "e861-1f29-d32d   32         Learned          XGE2/0/13                Y\n" +
                "e861-1f29-d345   32         Learned          XGE2/0/19                Y\n" +
                "e861-1f29-d347   32         Learned          XGE2/0/8                 Y\n" +
                "e861-1f29-d34d   32         Learned          XGE2/0/18                Y\n" +
                "e861-1f29-d497   32         Learned          XGE2/0/21                Y\n" +
                "e861-1f29-d4a3   32         Learned          XGE2/0/25                Y\n" +
                "e861-1f29-d5f1   32         Learned          XGE2/0/5                 Y\n" +
                "e861-1f29-d751   32         Learned          XGE2/0/9                 Y\n" +
                "e861-1f29-d79b   32         Learned          XGE2/0/6                 Y\n" +
                "e861-1f29-d8a9   32         Learned          XGE2/0/17                Y\n" +
                "e861-1f29-d909   32         Learned          XGE2/0/24                Y\n" +
                "e861-1f29-d975   32         Learned          XGE2/0/20                Y\n" +
                "e861-1f29-db03   32         Learned          XGE2/0/15                Y\n" +
                "e861-1f2b-24dd   32         Learned          XGE2/0/14                Y\n" +
                "e861-1f2b-2711   32         Learned          XGE2/0/16                Y\n" +
                "e861-1f2b-276b   32         Learned          XGE2/0/23                Y\n" +
                "<SH-YF-A-6800T-10.5.251.70>";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<MacEntry> macBasicIterableProcessor = new BasicIterableProcessor<MacEntry>(expectResult, new H3CMacTableProcessor());
        List<MacEntry> process = macBasicIterableProcessor.process();
        System.out.println(process);
    }

//    @Test
//    public void parseIpInterfaceBrief(){
//        String output = "disp ip int b\n" +
//                "*down: administratively down\n" +
//                "(s): spoofing  (l): loopback\n" +
//                "Interface           Physical Protocol IP address      VPN instance Description\n" +
//                "HGE1/0/59           up       up       10.5.253.106    --           --\n" +
//                "HGE1/0/60           up       up       10.5.253.134    --           --\n" +
//                "HGE2/0/59           up       up       10.5.253.110    --           --\n" +
//                "HGE2/0/60           up       up       10.5.253.138    --           --\n" +
//                "Loop0               up       up(s)    10.5.255.17     --           --\n" +
//                "MGE0/0/0            down     down     --              --           --\n" +
//                "MGE0/0/1            down     down     --              --           --\n" +
//                "Vlan1               down     down     --              --           --\n" +
//                "Vlan32              up       up       10.198.32.1     --           --\n" +
//                "Vlan251             up       up       10.5.251.65     --           --\n" +
//                "Vlan582             up       up       10.198.58.129   --           pxe_dhcp\n" +
//                "Vlan3000            up       up       1.1.1.5         --           --\n" +
//                "<SH-YF-C-9820-10.5.255.17>";
//        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
//        BasicIterableProcessor<Port> basicIterableProcessor = new BasicIterableProcessor<>(expectResult, new H3CIpInterfaceBriefProcessor());
//        List<Port> process = basicIterableProcessor.process();
//        System.out.println(process);
//    }

    @Test
    public void parseVlanNameMap() {
        String output = "disp vlan brief\n" +
                "Brief information about all VLANs:\n" +
                "Supported Minimum VLAN ID: 1\n" +
                "Supported Maximum VLAN ID: 4094\n" +
                "Default VLAN ID: 1\n" +
                "VLAN ID   Name                             Port\n" +
                "1         VLAN 0001                        BAGG19  BAGG20  HGE1/0/19\n" +
                "                                           HGE1/0/20  HGE1/0/21  HGE1/0/22\n" +
                "                                           HGE1/0/23  HGE1/0/24  HGE1/0/25\n" +
                "                                           HGE1/0/26  HGE1/0/27  HGE1/0/28\n" +
                "                                           HGE1/0/29  HGE1/0/30  HGE1/0/31\n" +
                "                                           HGE1/0/32  HGE1/0/33  HGE1/0/34\n" +
                "                                           HGE1/0/35  HGE1/0/36  HGE1/0/37\n" +
                "                                           HGE1/0/38  HGE1/0/39  HGE1/0/40\n" +
                "                                           HGE1/0/41  HGE1/0/42  HGE1/0/43\n" +
                "                                           HGE1/0/44  HGE1/0/45  HGE1/0/46\n" +
                "                                           HGE1/0/47  HGE1/0/48  HGE1/0/49\n" +
                "                                           HGE1/0/50  HGE1/0/51  HGE1/0/52\n" +
                "                                           HGE1/0/53  HGE1/0/54  HGE1/0/55\n" +
                "                                           HGE1/0/56  HGE1/0/57  HGE2/0/19\n" +
                "                                           HGE2/0/20  HGE2/0/21  HGE2/0/22\n" +
                "                                           HGE2/0/23  HGE2/0/24  HGE2/0/25\n" +
                "                                           HGE2/0/26  HGE2/0/27  HGE2/0/28\n" +
                "                                           HGE2/0/29  HGE2/0/30  HGE2/0/31\n" +
                "                                           HGE2/0/32  HGE2/0/33  HGE2/0/34\n" +
                "                                           HGE2/0/35  HGE2/0/36  HGE2/0/37\n" +
                "                                           HGE2/0/38  HGE2/0/39  HGE2/0/40\n" +
                "                                           HGE2/0/41  HGE2/0/42  HGE2/0/43\n" +
                "                                           HGE2/0/44  HGE2/0/45  HGE2/0/46\n" +
                "                                           HGE2/0/47  HGE2/0/48  HGE2/0/49\n" +
                "                                           HGE2/0/50  HGE2/0/51  HGE2/0/52\n" +
                "                                           HGE2/0/53  HGE2/0/54  HGE2/0/55\n" +
                "                                           HGE2/0/56  HGE2/0/57\n" +
                "4         VLAN 0004                        BAGG1  BAGG2  BAGG3  BAGG4  BAGG5\n" +
                "                                           BAGG6  BAGG7  BAGG8  BAGG9  BAGG10\n" +
                "                                           BAGG11  BAGG12  BAGG13  BAGG14\n" +
                "                                           BAGG15  BAGG16  BAGG17  BAGG18\n" +
                "                                           HGE1/0/1  HGE1/0/2  HGE1/0/3\n" +
                "                                           HGE1/0/4  HGE1/0/5  HGE1/0/6\n" +
                "                                           HGE1/0/7  HGE1/0/8  HGE1/0/9\n" +
                "                                           HGE1/0/10  HGE1/0/11  HGE1/0/12\n" +
                "                                           HGE1/0/13  HGE1/0/14  HGE1/0/15\n" +
                "                                           HGE1/0/16  HGE1/0/17  HGE1/0/18\n" +
                "                                           HGE2/0/1  HGE2/0/2  HGE2/0/3\n" +
                "                                           HGE2/0/4  HGE2/0/5  HGE2/0/6\n" +
                "                                           HGE2/0/7  HGE2/0/8  HGE2/0/9\n" +
                "                                           HGE2/0/10  HGE2/0/11  HGE2/0/12\n" +
                "                                           HGE2/0/13  HGE2/0/14  HGE2/0/15\n" +
                "                                           HGE2/0/16  HGE2/0/17  HGE2/0/18\n" +
                "16        VLAN 0016                        BAGG1  BAGG2  BAGG3  BAGG4  BAGG5\n" +
                "                                           BAGG6  BAGG7  BAGG8  BAGG9  BAGG10\n" +
                "                                           BAGG11  BAGG12  BAGG13  BAGG14\n" +
                "                                           BAGG15  BAGG16  BAGG17  BAGG18\n" +
                "                                           HGE1/0/1  HGE1/0/2  HGE1/0/3\n" +
                "                                           HGE1/0/4  HGE1/0/5  HGE1/0/6\n" +
                "                                           HGE1/0/7  HGE1/0/8  HGE1/0/9\n" +
                "                                           HGE1/0/10  HGE1/0/11  HGE1/0/12\n" +
                "                                           HGE1/0/13  HGE1/0/14  HGE1/0/15\n" +
                "                                           HGE1/0/16  HGE1/0/17  HGE1/0/18\n" +
                "                                           HGE2/0/1  HGE2/0/2  HGE2/0/3\n" +
                "                                           HGE2/0/4  HGE2/0/5  HGE2/0/6\n" +
                "                                           HGE2/0/7  HGE2/0/8  HGE2/0/9\n" +
                "                                           HGE2/0/10  HGE2/0/11  HGE2/0/12\n" +
                "                                           HGE2/0/13  HGE2/0/14  HGE2/0/15\n" +
                "                                           HGE2/0/16  HGE2/0/17  HGE2/0/18\n" +
                "251       VLAN 0251                        BAGG1  BAGG2  BAGG3  BAGG4  BAGG5\n" +
                "                                           BAGG6  BAGG7  BAGG8  BAGG9  BAGG10\n" +
                "                                           BAGG11  BAGG12  BAGG13  BAGG14\n" +
                "                                           BAGG15  BAGG16  BAGG17  BAGG18\n" +
                "                                           HGE1/0/1  HGE1/0/2  HGE1/0/3\n" +
                "                                           HGE1/0/4  HGE1/0/5  HGE1/0/6\n" +
                "                                           HGE1/0/7  HGE1/0/8  HGE1/0/9\n" +
                "                                           HGE1/0/10  HGE1/0/11  HGE1/0/12\n" +
                "                                           HGE1/0/13  HGE1/0/14  HGE1/0/15\n" +
                "                                           HGE1/0/16  HGE1/0/17  HGE1/0/18\n" +
                "                                           HGE2/0/1  HGE2/0/2  HGE2/0/3\n" +
                "                                           HGE2/0/4  HGE2/0/5  HGE2/0/6\n" +
                "                                           HGE2/0/7  HGE2/0/8  HGE2/0/9\n" +
                "                                           HGE2/0/10  HGE2/0/11  HGE2/0/12\n" +
                "                                           HGE2/0/13  HGE2/0/14  HGE2/0/15\n" +
                "                                           HGE2/0/16  HGE2/0/17  HGE2/0/18\n" +
                "612       VLAN 0612                        BAGG1  BAGG2  BAGG3  BAGG4  BAGG5\n" +
                "                                           BAGG6  BAGG7  BAGG8  BAGG9  BAGG10\n" +
                "                                           BAGG11  BAGG12  BAGG13  BAGG14\n" +
                "                                           BAGG15  BAGG16  BAGG17  BAGG18\n" +
                "                                           HGE1/0/1  HGE1/0/2  HGE1/0/3\n" +
                "                                           HGE1/0/4  HGE1/0/5  HGE1/0/6\n" +
                "                                           HGE1/0/7  HGE1/0/8  HGE1/0/9\n" +
                "                                           HGE1/0/10  HGE1/0/11  HGE1/0/12\n" +
                "                                           HGE1/0/13  HGE1/0/14  HGE1/0/15\n" +
                "                                           HGE1/0/16  HGE1/0/17  HGE1/0/18\n" +
                "                                           HGE2/0/1  HGE2/0/2  HGE2/0/3\n" +
                "                                           HGE2/0/4  HGE2/0/5  HGE2/0/6\n" +
                "                                           HGE2/0/7  HGE2/0/8  HGE2/0/9\n" +
                "                                           HGE2/0/10  HGE2/0/11  HGE2/0/12\n" +
                "                                           HGE2/0/13  HGE2/0/14  HGE2/0/15\n" +
                "                                           HGE2/0/16  HGE2/0/17  HGE2/0/18\n" +
                "3000      MAD-BFD-CHECK                    BAGG1  BAGG2  BAGG3  BAGG4  BAGG5\n" +
                "                                           BAGG6  BAGG7  BAGG8  BAGG9  BAGG10\n" +
                "                                           BAGG11  BAGG12  BAGG13  BAGG14\n" +
                "                                           BAGG15  BAGG16  BAGG17  BAGG18\n" +
                "                                           HGE1/0/1  HGE1/0/2  HGE1/0/3\n" +
                "                                           HGE1/0/4  HGE1/0/5  HGE1/0/6\n" +
                "                                           HGE1/0/7  HGE1/0/8  HGE1/0/9\n" +
                "                                           HGE1/0/10  HGE1/0/11  HGE1/0/12\n" +
                "                                           HGE1/0/13  HGE1/0/14  HGE1/0/15\n" +
                "                                           HGE1/0/16  HGE1/0/17  HGE1/0/18\n" +
                "                                           HGE1/0/62  HGE2/0/1  HGE2/0/2\n" +
                "                                           HGE2/0/3  HGE2/0/4  HGE2/0/5\n" +
                "                                           HGE2/0/6  HGE2/0/7  HGE2/0/8\n" +
                "                                           HGE2/0/9  HGE2/0/10  HGE2/0/11\n" +
                "                                           HGE2/0/12  HGE2/0/13  HGE2/0/14\n" +
                "                                           HGE2/0/15  HGE2/0/16  HGE2/0/17\n" +
                "                                           HGE2/0/18  HGE2/0/62\n" +
                "<SH-LG-C-9820-10.142.255.15>";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<L2Vlan> l2VlanBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new H3CVlanNameProcessor());
        List<L2Vlan> process = l2VlanBasicIterableProcessor.process();
        System.out.println(process);
    }

//    @Test
//    public void parseVlanDetail() {
//
//        String output = " disp ip int vlan 612\n" +
//                "Vlan-interface612 current state: UP\n" +
//                "Line protocol current state: UP\n" +
//                "Internet Address is 10.198.61.129/25 Primary\n" +
//                "Broadcast address: 10.198.61.255\n" +
//                "The Maximum Transmit Unit: 1500 bytes\n" +
//                "input packets : 0, bytes : 0, multicasts : 0\n" +
//                "output packets : 0, bytes : 0, multicasts : 0\n" +
//                "TTL invalid packet number:         0\n" +
//                "ICMP packet input number:          0\n" +
//                "  Echo reply:                      0\n" +
//                "  Unreachable:                     0\n" +
//                "  Source quench:                   0\n" +
//                "  Routing redirect:                0\n" +
//                "  Echo request:                    0\n" +
//                "  Router advert:                   0\n" +
//                "  Router solicit:                  0\n" +
//                "  Time exceed:                     0\n" +
//                "  IP header bad:                   0\n" +
//                "  Timestamp request:               0\n" +
//                "  Timestamp reply:                 0\n" +
//                "  Information request:             0\n" +
//                "  Information reply:               0\n" +
//                "  Netmask request:                 0\n" +
//                "  Netmask reply:                   0\n" +
//                "  Unknown type:                    0\n" +
//                "\n" +
//                "<SH-LG-C-9820-10.142.255.15>";
//        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
//        Segment generate = new H3CVlanDetailProcessor().generate(output);
//        System.out.println(generate);
//    }

    @Test
    public void parseIpInterfaceBrief() {
        String output = "disp ip int b\n" +
                "*down: administratively down\n" +
                "(s): spoofing  (l): loopback\n" +
                "Interface           Physical Protocol IP address      VPN instance Description\n" +
                "HGE1/0/58           up       up       --              --           --\n" +
                "HGE1/0/59           up       up       --              --           --\n" +
                "HGE1/0/60           up       up       --              --           --\n" +
                "HGE1/0/61           up       up       --              --           --\n" +
                "HGE2/0/58           up       up       --              --           --\n" +
                "HGE2/0/59           up       up       --              --           --\n" +
                "HGE2/0/60           up       up       --              --           --\n" +
                "HGE2/0/61           up       up       --              --           --\n" +
                "Loop0               up       up(s)    10.142.255.15   --           --\n" +
                "MGE0/0/0            down     down     --              --           --\n" +
                "MGE0/0/1            down     down(s)  --              --           --\n" +
                "RAGG58              up       up       10.142.253.34   --           To_SH-YF-C...\n" +
                "RAGG59              up       up       10.142.253.42   --           To_SH-YF-C...\n" +
                "RAGG60              up       up       10.142.253.50   --           To_SH-YF-C...\n" +
                "RAGG61              up       up       10.142.253.58   --           To_SH-YF-C...\n" +
                "Vlan1               *down    down     --              --           --\n" +
                "Vlan4               up       up       10.142.4.1      --           --\n" +
                "Vlan16              up       up       10.142.16.1     --           research\n" +
                "Vlan251             up       up       10.142.251.1    --           --\n" +
                "Vlan612             up       up       10.198.61.129   --           PXE_DHCP\n" +
                "Vlan3000            up       up       1.1.1.5         --           --\n" +
                "<SH-LG-C-9820-10.142.255.15>";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<Port> portBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new H3CIpInterfaceBriefProcessor());
        List<Port> process = portBasicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void h3cPortChannelNumsParserTest() {
        String output = "[SH-YF-A-6800T-10.198.0.15]disp interface Bridge-Aggregation brief description\n" +
                "Brief information on interfaces in bridge mode:\n" +
                "Link: ADM - administratively down; Stby - standby\n" +
                "Speed: (a) - auto\n" +
                "Duplex: (a)/A - auto; H - half; F - full\n" +
                "Type: A - access; T - trunk; H - hybrid\n" +
                "Interface            Link Speed   Duplex Type PVID Description\n" +
                "BAGG1                UP   20G(a)  F(a)   T    1    To_10.198.19.60\n" +
                "BAGG2                UP   20G(a)  F(a)   T    1    To_10.198.19.61\n" +
                "BAGG3                UP   20G(a)  F(a)   T    1    To_10.198.19.62\n" +
                "BAGG4                UP   20G(a)  F(a)   T    1    To_10.198.19.63\n" +
                "BAGG5                UP   20G(a)  F(a)   T    1    To_10.198.19.64\n" +
                "BAGG6                UP   20G(a)  F(a)   T    1    To_10.198.19.65\n" +
                "BAGG7                UP   20G(a)  F(a)   T    1    To_10.198.19.66\n" +
                "BAGG8                UP   20G(a)  F(a)   T    1    To_10.198.19.67\n" +
                "BAGG9                UP   20G(a)  F(a)   T    1    To_10.198.19.68\n" +
                "BAGG10               UP   20G(a)  F(a)   T    1    To_10.198.19.69\n" +
                "BAGG11               UP   20G(a)  F(a)   T    1    To_10.198.19.70\n" +
                "BAGG12               UP   20G(a)  F(a)   T    1    To_10.198.19.71\n" +
                "BAGG13               UP   20G(a)  F(a)   T    1    To_10.198.19.72\n" +
                "BAGG14               UP   20G(a)  F(a)   T    1    To_10.198.19.73\n" +
                "BAGG15               UP   20G(a)  F(a)   T    1    To_10.198.19.74\n" +
                "BAGG16               UP   20G(a)  F(a)   T    1\n" +
                "BAGG17               UP   20G(a)  F(a)   T    1\n" +
                "BAGG18               UP   20G(a)  F(a)   T    1\n" +
                "BAGG19               UP   20G(a)  F(a)   T    1\n" +
                "BAGG20               UP   20G(a)  F(a)   T    1\n" +
                "BAGG21               UP   20G(a)  F(a)   T    1\n" +
                "BAGG22               UP   20G(a)  F(a)   T    1\n" +
                "BAGG23               UP   20G(a)  F(a)   T    1\n" +
                "BAGG24               UP   20G(a)  F(a)   T    1\n" +
                "BAGG25               UP   20G(a)  F(a)   T    1\n" +
                "BAGG100              UP   160G(a) F(a)   T    1    To_SZ-SK-C-9336-10.112.255.11-12";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<Integer> integerBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new H3CPortGroupSummaryProcessor());
        List<Integer> nums = integerBasicIterableProcessor.process();
        System.out.println(nums);
    }

    @Test
    public void testParseH3CGetPortStatusList(){
        String output = "<SH-YF-C-9820-10.5.255.17>disp interface brief description\n" +
                "Brief information on interfaces in route mode:\n" +
                "Link: ADM - administratively down; Stby - standby\n" +
                "Protocol: (s) - spoofing\n" +
                "Interface            Link Protocol Primary IP      Description\n" +
                "HGE1/0/59            UP   UP       10.5.253.106\n" +
                "HGE1/0/60            UP   UP       10.5.253.134\n" +
                "HGE2/0/59            UP   UP       10.5.253.110\n" +
                "HGE2/0/60            UP   UP       10.5.253.138\n" +
                "InLoop0              UP   UP(s)    --\n" +
                "Loop0                UP   UP(s)    10.5.255.17\n" +
                "MGE0/0/0             DOWN DOWN     --\n" +
                "MGE0/0/1             DOWN DOWN     --\n" +
                "NULL0                UP   UP(s)    --\n" +
                "REG0                 UP   --       --\n" +
                "Vlan1                DOWN DOWN     --\n" +
                "Vlan32               UP   UP       10.198.32.1\n" +
                "Vlan251              UP   UP       10.5.251.65\n" +
                "Vlan582              UP   UP       10.198.58.129\n" +
                "Vlan3000             UP   UP       1.1.1.5\n" +
                "\n" +
                "Brief information on interfaces in bridge mode:\n" +
                "Link: ADM - administratively down; Stby - standby\n" +
                "Speed: (a) - auto\n" +
                "Duplex: (a)/A - auto; H - half; F - full\n" +
                "Type: A - access; T - trunk; H - hybrid\n" +
                "Interface            Link Speed   Duplex Type PVID Description\n" +
                "BAGG1                UP   400G(a) F(a)   T    1    To_SH-YF-A-6800T-10.5.251.68\n" +
                "BAGG2                UP   400G(a) F(a)   T    1    To_SH-YF-A-6800T-10.5.251.69\n" +
                "BAGG3                UP   400G(a) F(a)   T    1    To_SH-YF-A-6800T-10.5.251.70\n" +
                "HGE1/0/1             UP   100G(a) F(a)   T    1\n" +
                "HGE1/0/2             UP   100G(a) F(a)   T    1\n" +
                "HGE1/0/3             UP   100G(a) F(a)   T    1\n" +
                "HGE1/0/4             UP   100G(a) F(a)   T    1\n" +
                "HGE1/0/5             UP   100G(a) F(a)   T    1\n" +
                "HGE1/0/6             UP   100G(a) F(a)   T    1\n" +
                "HGE1/0/7             DOWN auto    A      A    1\n" +
                "HGE1/0/8             DOWN auto    A      A    1\n" +
                "HGE1/0/9             DOWN auto    A      A    1\n" +
                "HGE1/0/10            DOWN auto    A      A    1\n" +
                "HGE1/0/11            DOWN auto    A      A    1\n" +
                "HGE1/0/12            DOWN auto    A      A    1\n" +
                "HGE1/0/13            DOWN auto    A      A    1\n" +
                "HGE1/0/14            DOWN auto    A      A    1\n" +
                "HGE1/0/15            DOWN auto    A      A    1\n" +
                "HGE1/0/16            DOWN auto    A      A    1\n" +
                "HGE1/0/17            DOWN auto    A      A    1\n" +
                "HGE1/0/18            DOWN auto    A      A    1\n" +
                "HGE1/0/19            DOWN auto    A      A    1\n" +
                "HGE1/0/20            DOWN auto    A      A    1\n" +
                "HGE1/0/21            DOWN auto    A      A    1\n" +
                "HGE1/0/22            DOWN auto    A      A    1\n" +
                "HGE1/0/23            DOWN auto    A      A    1\n" +
                "HGE1/0/24            DOWN auto    A      A    1\n" +
                "HGE1/0/25            DOWN auto    A      A    1\n" +
                "HGE1/0/26            DOWN auto    A      A    1\n" +
                "HGE1/0/27            DOWN auto    A      A    1\n" +
                "HGE1/0/28            DOWN auto    A      A    1\n" +
                "HGE1/0/29            DOWN auto    A      A    1\n" +
                "HGE1/0/30            DOWN auto    A      A    1\n" +
                "HGE1/0/31            DOWN auto    A      A    1\n" +
                "HGE1/0/32            DOWN auto    A      A    1\n" +
                "HGE1/0/33            DOWN auto    A      A    1\n" +
                "HGE1/0/34            DOWN auto    A      A    1\n" +
                "HGE1/0/35            DOWN auto    A      A    1\n" +
                "HGE1/0/36            DOWN auto    A      A    1\n" +
                "HGE1/0/37            DOWN auto    A      A    1\n" +
                "HGE1/0/38            DOWN auto    A      A    1\n" +
                "HGE1/0/39            DOWN auto    A      A    1\n" +
                "HGE1/0/40            DOWN auto    A      A    1\n" +
                "HGE1/0/41            DOWN auto    A      A    1\n" +
                "HGE1/0/42            DOWN auto    A      A    1\n" +
                "HGE1/0/43            DOWN auto    A      A    1\n" +
                "HGE1/0/44            DOWN auto    A      A    1\n" +
                "HGE1/0/45            DOWN auto    A      A    1\n" +
                "HGE1/0/46            DOWN auto    A      A    1\n" +
                "HGE1/0/47            DOWN auto    A      A    1\n" +
                "HGE1/0/48            DOWN auto    A      A    1\n" +
                "HGE1/0/49            DOWN auto    A      A    1\n" +
                "HGE1/0/50            DOWN auto    A      A    1\n" +
                "HGE1/0/51            DOWN auto    A      A    1\n" +
                "HGE1/0/52            DOWN auto    A      A    1\n" +
                "HGE1/0/53            DOWN auto    A      A    1\n" +
                "HGE1/0/54            DOWN auto    A      A    1\n" +
                "HGE1/0/55            DOWN auto    A      A    1\n" +
                "HGE1/0/56            DOWN auto    A      A    1\n" +
                "HGE1/0/57            DOWN auto    A      A    1\n" +
                "HGE1/0/58            DOWN auto    A      A    1\n" +
                "HGE1/0/61            DOWN auto    A      A    1\n" +
                "HGE1/0/62            UP   100G(a) F(a)   A    3000 stack_port\n" +
                "HGE1/0/63            UP   100G(a) F(a)   --   --   stack_port\n" +
                "HGE1/0/64            UP   100G(a) F(a)   --   --   stack_port\n" +
                "HGE2/0/1             UP   100G(a) F(a)   T    1\n" +
                "HGE2/0/2             UP   100G(a) F(a)   T    1\n" +
                "HGE2/0/3             UP   100G(a) F(a)   T    1\n" +
                "HGE2/0/4             UP   100G(a) F(a)   T    1\n" +
                "HGE2/0/5             UP   100G(a) F(a)   T    1\n" +
                "HGE2/0/6             UP   100G(a) F(a)   T    1\n" +
                "HGE2/0/7             DOWN auto    A      A    1\n" +
                "HGE2/0/8             DOWN auto    A      A    1\n" +
                "HGE2/0/9             DOWN auto    A      A    1\n" +
                "HGE2/0/10            DOWN auto    A      A    1\n" +
                "HGE2/0/11            DOWN auto    A      A    1\n" +
                "HGE2/0/12            DOWN auto    A      A    1\n" +
                "HGE2/0/13            DOWN auto    A      A    1\n" +
                "HGE2/0/14            DOWN auto    A      A    1\n" +
                "HGE2/0/15            DOWN auto    A      A    1\n" +
                "HGE2/0/16            DOWN auto    A      A    1\n" +
                "HGE2/0/17            DOWN auto    A      A    1\n" +
                "HGE2/0/18            DOWN auto    A      A    1\n" +
                "HGE2/0/19            DOWN auto    A      A    1\n" +
                "HGE2/0/20            DOWN auto    A      A    1\n" +
                "HGE2/0/21            DOWN auto    A      A    1\n" +
                "HGE2/0/22            DOWN auto    A      A    1\n" +
                "HGE2/0/23            DOWN auto    A      A    1\n" +
                "HGE2/0/24            DOWN auto    A      A    1\n" +
                "HGE2/0/25            DOWN auto    A      A    1\n" +
                "HGE2/0/26            DOWN auto    A      A    1\n" +
                "HGE2/0/27            DOWN auto    A      A    1\n" +
                "HGE2/0/28            DOWN auto    A      A    1\n" +
                "HGE2/0/29            DOWN auto    A      A    1\n" +
                "HGE2/0/30            DOWN auto    A      A    1\n" +
                "HGE2/0/31            DOWN auto    A      A    1\n" +
                "HGE2/0/32            DOWN auto    A      A    1\n" +
                "HGE2/0/33            DOWN auto    A      A    1\n" +
                "HGE2/0/34            DOWN auto    A      A    1\n" +
                "HGE2/0/35            DOWN auto    A      A    1\n" +
                "HGE2/0/36            DOWN auto    A      A    1\n" +
                "HGE2/0/37            DOWN auto    A      A    1\n" +
                "HGE2/0/38            DOWN auto    A      A    1\n" +
                "HGE2/0/39            DOWN auto    A      A    1\n" +
                "HGE2/0/40            DOWN auto    A      A    1\n" +
                "HGE2/0/41            DOWN auto    A      A    1\n" +
                "HGE2/0/42            DOWN auto    A      A    1\n" +
                "HGE2/0/43            DOWN auto    A      A    1\n" +
                "HGE2/0/44            DOWN auto    A      A    1\n" +
                "HGE2/0/45            DOWN auto    A      A    1\n" +
                "HGE2/0/46            DOWN auto    A      A    1\n" +
                "HGE2/0/47            DOWN auto    A      A    1\n" +
                "HGE2/0/48            DOWN auto    A      A    1\n" +
                "HGE2/0/49            DOWN auto    A      A    1\n" +
                "HGE2/0/50            DOWN auto    A      A    1\n" +
                "HGE2/0/51            DOWN auto    A      A    1\n" +
                "HGE2/0/52            DOWN auto    A      A    1\n" +
                "HGE2/0/53            DOWN auto    A      A    1\n" +
                "HGE2/0/54            DOWN auto    A      A    1\n" +
                "HGE2/0/55            DOWN auto    A      A    1\n" +
                "HGE2/0/56            DOWN auto    A      A    1\n" +
                "HGE2/0/57            DOWN auto    A      A    1\n" +
                "HGE2/0/58            DOWN auto    A      A    1\n" +
                "HGE2/0/61            DOWN auto    A      A    1\n" +
                "HGE2/0/62            UP   100G(a) F(a)   A    3000 stack_port\n" +
                "HGE2/0/63            UP   100G(a) F(a)   --   --   stack_port\n" +
                "HGE2/0/64            UP   100G(a) F(a)   --   --   stack_port\n" +
                "\n" +
                "<SH-YF-C-9820-10.5.255.17>";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        BasicIterableProcessor<PortStatus> portStatusBasicIterableProcessor = new BasicIterableProcessor<>(expectResult, new H3CPortStatusProcessor());
        List<PortStatus> process = portStatusBasicIterableProcessor.process();
        System.out.println(process);
    }

    @Test
    public void testParseL3VlanDetail(){
        String output = "disp ip int vlan 32\n" +
                "Vlan-interface32 current state: UP\n" +
                "Line protocol current state: UP\n" +
                "Internet Address is 10.198.32.1/23 Primary\n" +
                "Broadcast address: 10.198.33.255\n" +
                "The Maximum Transmit Unit: 1500 bytes\n" +
                "input packets : 0, bytes : 0, multicasts : 0\n" +
                "output packets : 0, bytes : 0, multicasts : 0\n" +
                "TTL invalid packet number:         0\n" +
                "ICMP packet input number:     808735\n" +
                "  Echo reply:                     42\n" +
                "  Unreachable:                     0\n" +
                "  Source quench:                   0\n" +
                "  Routing redirect:                0\n" +
                "  Echo request:               808693\n" +
                "  Router advert:                   0\n" +
                "  Router solicit:                  0\n" +
                "  Time exceed:                     0\n" +
                "  IP header bad:                   0\n" +
                "  Timestamp request:               0\n" +
                "  Timestamp reply:                 0\n" +
                "  Information request:             0\n" +
                "  Information reply:               0\n" +
                "  Netmask request:                 0\n" +
                "  Netmask reply:                   0\n" +
                "  Unknown type:                    0\n" +
                "\n" +
                "<SH-YF-C-9820-10.5.255.17>";
        ExpectResult expectResult = new ExpectResult(true, 0, "", output);
        H3CVlanDetailProcessor h3CVlanDetailProcessor = new H3CVlanDetailProcessor();
        Segment generate = h3CVlanDetailProcessor.generate(expectResult.getOutput());
        System.out.println(generate);
    }
}