package com.sagar.training.cassandra.executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

public class GetFindCassandra2 {
	
	private static Cluster cluster;
	private static Session session;
	
	static QueryOptions qo = new QueryOptions().setConsistencyLevel(ConsistencyLevel.ALL);
	
	public static Cluster connect(String node, String user, String pw) {
		return Cluster.builder()
				.addContactPoint(node)
				.withCredentials(user, pw)
				.withQueryOptions(qo)
				.build();
	}
	
	public static void main(String args[]) {
		cluster = connect("10.247.145.72", "limo_app", "app_limo");
		session = cluster.connect();
		
		List<String> offers = new ArrayList<>(Arrays.asList("0abdad9c-fcb3-4173-9428-fcaa0c912adc","0f4bcafb-cf79-47cb-a14f-6fb37b1e4a13","1200b86c-7916-4126-8525-ebf3def36893","153afeeb-89f6-461d-b22c-5f44f28fdd00","1555d542-4133-44a6-b6c6-4bc2c3f566b8","16702cf2-d53e-42aa-b11a-89aef063ca2c","171e0177-cbf5-41f6-9981-af52738fd29c","18c050ed-38b4-4aa1-99a1-e7fea9cd432e","19c7b755-fc7a-4dcf-8830-13ea6e8a5e80","1bb4d24c-1552-4f26-b646-33848f128903","1d65f333-8fb1-4950-bce0-4f9e11991792","1ee359ec-1481-428b-856e-edc52e15e03f","21604a66-52ee-434b-aed6-b05affab02e9","21f2d7fb-8d52-4cb0-b6e6-d2f1ac84999f","2c16d3fb-a9cd-4c55-a5e2-de68ae41a7cc","2cd8a2e1-936c-48b9-abcc-ef0bb7ec99c4","30b5d953-e460-421e-913d-e485fd4db071","31c07838-5319-41b8-98f8-338a3371e9d3","36b0b945-b851-48ab-99bb-9d7651924172","36f249eb-a0e7-479a-8347-e70cc8d629e7","39f9b0b0-0d01-45c6-bb35-aabd3676d71d","3a229033-35d8-4c76-8be4-86532092583c","3a8813b9-25f9-4891-a3fe-f5b681261e5c","3aa5ef14-f4c0-43f6-9fb6-b499befcc53b","3afb31a7-dc0b-46cc-85e7-dae66d192bd5","3c24259a-69e2-4de4-b0ce-9728df6e824c","3d531ca7-a3eb-440e-b5e0-2b81a169f406","3d80067e-30e1-4fb7-b5a0-16c55a5390e6","3e312584-2064-4d96-8cb3-74b7ff09b333","3eec444d-1107-40f8-807e-3f1970925b70","424bade6-41df-4327-ae10-32b44035f548","4327df98-0f7d-41c0-9c13-be31458ca1fb","436f7d53-b0ea-48f0-84af-545484a05839","47221120-1375-46bd-bd5b-89a19169fd82","4874fe39-382c-4ceb-a4d9-38e86a261131","4b5cb504-fd48-4a3e-8f6f-0665a869ca62","4d53e2ce-82a6-4250-8829-8f47220bf72a","4eec2b4e-1aee-4282-98c5-1810306cb636","517d6103-230d-4da1-b0f7-dbabc1bee343","5416d103-d6ec-476b-ad40-253c5cfcc436","5fa4e460-abc9-4472-b73b-8eb68f114559","605a04ff-07ff-44f0-8651-e4aa061c00b8","693df267-649f-4113-9c22-bbad79e92e18","6a04919a-1185-437f-993e-d945c73a4de7","6ce8b65f-7798-461f-b3c7-df72bc203a78","7014dcb1-3735-4798-a574-cee0d8fdef07","718e5c86-ebbb-4d61-b532-a07c28eee220","719cb167-987e-43e4-86b5-951d7aed7355","74046007-8e19-4e19-ace2-f400cf5ca991","7573961c-93c9-4caf-aff4-50994b4c4c7d","76b772fd-61a0-4806-9853-8be92d3efe1c","78024af7-8a2a-4806-8f28-88e2708ae083","79c331d1-f8a2-48a6-b048-cfe814479847","7a2cd66c-0887-473f-b0b6-879e376cab0d","7dfec6f1-5aba-49f0-8f2c-8748ef5d18a6","7e252a3a-e71c-4e9d-a0dd-f03447e29335","82277d16-77b3-4b81-88f0-68f211d2436c","8286079b-5e77-4965-839b-0fb7f4afa87e","829e0477-97dc-4c1e-9352-4c34b7832625","86251113-a34b-44e7-bba5-2922ac9a3ce2","86a6abd3-0fbf-4659-9e67-d18aa85fa73e","87852ec2-3cd7-4121-9819-0ba5a7998ccc","8b3019a4-a249-41c9-b81e-b8465d978a24","8bb70a0c-6138-4386-91d0-d188ee41a7cf","8ddcc59e-8105-4fc6-9938-392d9e6e2884","92a942c2-b11e-440e-90f0-59b376aaf807","9903331c-c5c1-4e2e-a043-fcd20e9b197f","9b97d8a8-57ef-4747-9626-d620d584fee5","9c66787b-4b23-4123-acea-41c1b3f56024","a4203224-1861-43ba-bd09-d9489d2ddd00","ab9ba9c7-cf89-46e1-8060-de706f49746a","ac40c38e-e36e-4817-9978-868dbcb618bd","b0e0ceb2-2839-45b4-ac09-aabd405404ec","b902c282-3a42-4542-aa21-8c3c3d47cc13","b960178e-3d30-48a9-a651-6bb111dfccfd","bccdcf32-3433-49b8-b2d8-105a087c55e8","bda3c8c3-0f27-4bac-9518-c4fa4c0e039a","be0a8b95-2d03-4e7e-b540-5099c668a755","bfb28863-5c62-475c-8caa-92b091d57755","c137aac0-87f4-4403-8a2a-755438544af7","c1a2d580-e1e0-4a6e-8648-5e22750ab515","cba5aa42-91b2-449f-b293-ee3304deec16","cbc741cd-8c54-4cb4-b23e-df224d2928f7","cfd47d62-da51-407b-82be-38981e93d48b","d0404c52-c3af-4811-adc4-965129c2d3b3","d7d568d0-2746-4143-a186-1d49c5ed2d39","d8ecc963-5785-4c49-89c8-cf48222856bf","dbbf33b5-ddda-40f9-853d-deadd3acaa37","de361b2a-6524-4843-a5c3-d0e68dadbdba","e232d8f2-a50c-4304-8e9c-24b27a27a87a","e6716f70-6e9e-42a6-a6d0-be341c0dff18","ea4a5766-07b0-4d59-88fb-5eda20e88a7a","f37c31ad-fb13-4c99-b739-0398b6f11f9e","f39803b9-a7ea-43ee-9d6b-08c3ad2c28f4","f5965385-eff1-4352-85d9-05ccbe168152","f6cd125c-802f-43b3-8dc5-36df50b2f2d7","fac7e5f9-66b0-4443-af55-0c0a3ca652fc","fc185791-8e0a-40bf-ba1e-362573f55da1"));
		List<String> storeids = new ArrayList<>(Arrays.asList("4","5","7","11","13","16","19","24","26","29","41","47","52","58","59","69","70","73","75","85","86","93","94","103","112","113","125","129","130","137","138","141","144","147","151","154","157","159","164","168","172","175","184","185","195","196","201","202","206","212","216","217","220","221","228","234","240","259","260","261","266","269","272","277","278","284","285","286","297","299","304","307","309","313","319","322","331","332","335","351","355","356","361","365","371","374","375","376","377","381","383","388","389","393","394","397","398","399","400","402","404","406","407","408","414","415","420","423","426","427","433","434","444","450","452","456","457","459","464","465","468","472","475","477","489","491","493","500","511","514","517","521","522","525","526","529","531","532","533","535","536","537","538","539","541","544","546","553","560","562","564","566","571","572","573","575","577","579","589","590","592","599","601","602","604","608","613","616","618","620","622","623","628","630","631","635","640","643","649","651","659","660","662","669","670","672","673","674","685","688","690","694","697","701","702","703","706","709","710","722","725","743","744","746","749","753","755","764","765","766","769","771","773","777","778","781","793","794","796","807","817","818","819","822","828","838","842","844","848","849","852","859","860","861","865","866","872","877","881","884","890","892","894","901","905","911","912","916","919","920","929","934","935","937","939","940","942","943","945","948","950","953","963","967","972","974","984","987","990","991","992","994","995","999","1000","1003","1004","1009","1011","1016","1017","1021","1022","1028","1032","1040","1042","1044","1053","1055","1060","1062","1066","1071","1075","1077","1080","1081","1083","1085","1094","1099","1101","1103","1105","1117","1125","1126","1129","1141","1146","1148","1150","1151","1156","1158","1160","1163","1167","1173","1176","1177","1178","1179","1184","1185","1191","1193","1194","1195","1198","1199","1201","1203","1204","1207","1210","1212","1216","1219","1221","1222","1223","1224","1225","1226","1227","1229","1232","1238","1241","1242","1244","1245","1248","1252","1254","1261","1266","1270","1273","1276","1281","1286","1292","1299","1301","1303","1307","1310","1311","1312","1317","1318","1320","1322","1339","1341","1342","1344","1346","1347","1348","1350","1355","1356","1361","1362","1364","1367","1373","1376","1377","1378","1379","1387","1390","1392","1397","1399","1400","1401","1406","1408","1410","1413","1417","1421","1423","1424","1426","1430","1434","1440","1441","1443","1444","1447","1455","1458","1463","1464","1465","1469","1472","1479","1488","1490","1491","1494","1496","1510","1514","1515","1523","1524","1525","1527","1528","1533","1540","1541","1545","1552","1556","1557","1558","1568","1571","1578","1590","1591","1595","1596","1597","1601","1609","1611","1618","1619","1626","1627","1631","1633","1635","1637","1645","1646","1651","1652","1659","1660","1668","1669","1671","1674","1677","1681","1682","1686","1687","1688","1700","1702","1708","1710","1720","1721","1728","1734","1735","1736","1739","1741","1742","1747","1748","1754","1757","1759","1768","1773","1774","1777","1780","1789","1793","1796","1799","1801","1802","1804","1805","1810","1811","1814","1819","1831","1833","1837","1847","1848","1850","1851","1855","1860","1861","1870","1874","1875","1878","1883","1884","1885","1886","1888","1890","1891","1896","1898","1899","1902","1909","1913","1916","1938","1940","1941","1942","1943","1951","1964","1966","1968","1969","1971","1982","1985","1988","1991","1993","2001","2003","2005","2006","2013","2019","2021","2024","2036","2040","2046","2050","2051","2056","2058","2064","2065","2079","2083","2086","2089","2094","2095","2101","2102","2104","2108","2111","2112","2119","2122","2123","2125","2131","2136","2142","2145","2147","2154","2157","2169","2174","2181","2197","2198","2201","2204","2214","2218","2221","2233","2234","2239","2255","2256","2265","2266","2274","2275","2278","2279","2282","2283","2300","2306","2307","2309","2310","2313","2322","2325","2330","2331","2334","2335","2336","2339","2350","2352","2354","2355","2357","2359","2360","2366","2385","2386","2387","2397","2399","2414","2420","2425","2426","2437","2439","2443","2444","2445","2447","2448","2463","2464","2465","2471","2472","2483","2493","2494","2497","2499","2502","2505","2508","2511","2512","2529","2539","2541","2543","2549","2550","2552","2560","2561","2566","2575","2577","2581","2587","2588","2590","2592","2595","2599","2600","2612","2618","2628","2629","2637","2642","2644","2649","2658","2665","2671","2678","2679","2685","2686","2688","2690","2691","2692","2693","2695","2712","2713","2715","2716","2717","2720","2725","2727","2740","2745","2748","2755","2757","2766","2774","2777","2780","2781","2786","2787","2788","2789","2793","2796","2803","2804","2807","2808","2812","2817","2821","2827","2832","2839","2843","2844","2846","2847","2850","2855","2857","2860","2862","2864","2869","2870","2872","2874","2876","2882","2883","2884","2886","2892","2913","2918","2920","2921","2922","2927","2928","2932","2938","2939","2941","2944","2945","2946","2950","2955","2956","2958","2962","2963","2964","2966","2973","2980","2985","2986","2991","2993","2995","3017","3043","3047","3050","3055","3056","3061","3077","3078","3084","3093","3098","3106","3126","3128","3136","3138","3139","3144","3150","3164","3169","3182","3185","3204","3205","3207","3208","3209","3210","3213","3214","3215","3216","3219","3222","3223","3224","3225","3226","3227","3230","3232","3236","3237","3241","3243","3254","3255","3259","3261","3265","3267","3273","3274","3275","3277","3278","3281","3283","3284","3285","3286","3293","3294","3295","3297","3298","3302","3307","3308","3310","3313","3324","3327","3336","3338","3340","3347","3348","3349","3352","3356","3359","3363","3364","3366","3367","3380","3382","3383","3387","3388","3389","3390","3391","3397","3401","3402","3403","3406","3407","3409","3411","3414","3417","3425","3431","3434","3436","3439","3442","3449","3450","3454","3458","3459","3460","3461","3462","3471","3473","3475","3482","3483","3484","3487","3492","3495","3502","3503","3510","3513","3516","3518","3521","3522","3523","3525","3529","3531","3533","3535","3538","3564","3566","3568","3569","3570","3571","3572","3580","3588","3589","3590","3597","3602","3604","3608","3609","3611","3612","3617","3619","3620","3624","3626","3627","3629","3630","3631","3633","3639","3640","3644","3646","3652","3654","3655","3659","3660","3700","3705","3708","3709","3713","3722","3726","3728","3729","3731","3732","3733","3739","3746","3749","3751","3757","3762","3763","3773","3774","3775","3777","3780","3782","3785","3786","3788","3790","3796","3799","3802","3804","3823","3824","3825","3826","3827","3828","3835","3837","3838","3842","3846","3848","3851","3867","3868","3874","3886","3887","3888","3889","3892","3894","3896","3899","3935","3959","3988","4054","4056","4065","4104","4108","4115","4118","4129","4140","4153","4163","4168","4171","4176","4183","4185","4195","4203","4219","4223","4230","4235","4237","4238","4239","4240","4241","4243","4250","4255","4256","4262","4272","4273","4274","4277","4279","4286","4288","4295","4298","4299","4318","4321","4323","4324","4325","4330","4333","4334","4335","4336","4340","4352","4365","4368","4375","4376","4379","4381","4384","4387","4388","4394","4404","4407","4410","4417","4421","4423","4426","4431","4434","4436","4438","4440","4443","4444","4446","4450","4452","4453","4456","4458","4460","4464","4465","4466","4468","4469","4470","4472","4475","4476","4478","4479","4482","4483","4484","4490","4491","4497","4503","4509","4511","4512","4514","4516","4517","4520","4521","4529","4530","4533","4538","4540","4546","4565","4567","4579","4582","4585","4586","4588","4589","4590","4591","4597","4600","4601","4605","4611","4612","4615","4618","4619","4635","4637","4638","4639","4643","4644","4654","4655","4659","4660","4664","4672","4673","4676","4677","4695","4697","4756","4759","4826","4865","5008","5012","5025","5029","5030","5031","5035","5036","5038","5039","5041","5045","5046","5049","5055","5056","5058","5060","5062","5063","5065","5066","5070","5071","5078","5079","5080","5081","5085","5091","5092","5096","5099","5105","5109","5115","5116","5117","5134","5137","5139","5141","5143","5144","5146","5148","5154","5155","5156","5157","5167","5174","5182","5185","5186","5188","5191","5192","5193","5197","5199","5204","5210","5211","5214","5215","5216","5218","5233","5234","5235","5236","5239","5240","5241","5244","5245","5247","5252","5253","5254","5256","5260","5264","5265","5266","5270","5272","5275","5278","5279","5280","5287","5291","5296","5299","5300","5304","5307","5310","5311","5312","5313","5316","5317","5320","5323","5326","5327","5329","5334","5336","5337","5341","5343","5347","5349","5352","5353","5361","5363","5364","5367","5368","5369","5371","5373","5379","5389","5390","5391","5393","5403","5418","5421","5427","5428","5430","5435","5438","5439","5441","5443","5449","5450","5452","5455","5459","5462","5463","5466","5469","5472","5476","5479","5480","5481","5483","5487","5490","5491","5494","5499","5608","5612","5628","5653","5668","5672","5676","5678","5700","5702","5703","5706","5707","5709","5713","5715","5716","5727","5728","5734","5740","5741","5743","5744","5748","5764","5769","5771","5774","5776","5782","5795","5797","5823","5824","5828","5832","5837","5841","5842","5843","5844","5845","5851","5879","5884","5894","5898","5922","5929","5959","5976","5987","6149","6165","6173","6207","6233","6243","6300","6323","6398","6467","6469","6470","6480","6531","6583","6586","6587","6807","6878","6894","6929","6932","6936","6963","6964","6966","6975","7032","7062","7137","7177","7179","7181","7185","7220","7229","7233","7251","7254","7262","7280","7294","7298","7301","7307","7311","7324","7326","7339","7342","7347","7349","7809","8958","304","329","400","467","511","616","638","670","701","709","773","814","1017","1379","1439","1568","1891","1900","1987","2003","2153","2202","2325","2362","2852","2923","3220","3288","3349","3363","3583","3612","3887","4068","4203","4487","4627","4678","4696","5071","5078","5088","5272","5410","5678","7280","37","95","188","192","551","708","735","754","786","809","981","1155","1197","1213","1253","1280","1284","1338","1481","1632","1807","1956","2071","2244","2534","2887","2890","3018","3059","3331","3339","3370","3582","3606","3990","4692","5175","5263","5342","5477","5780","5789","5790","5903","5907","5923","6477","7221","7340","4564","1298","3864","1661","1010","1034","2069","5840","2243","4545","462","808","789","4371","4373","2098","2340","5839","5125","543","5464","1351","1714","3537","1113","5319","719","1450","2811","3474","4528","767","547","1087","5789","5790","1939","3331","4540","1438","188","5606","2066","1842","3304","3658","5292","5829","410","469","6789","163","653","5059","3362","988","6978","667","1263","140","655","1309","428","5297","4631","5267","2013","5090","4395","1305","5890","2214","2312","60","804","585","2105","2427","5861","110","1614","3259","148","705","1104","483","938","3423","603","1911","4494","5816","5258","2981","5087","2554","2469","1407","3784","7320","4392","970","661","5925","1030","5206","5477","10","1600","1669","1096","1935","2813","4531","5119","1678","909","4561","119","2822","1640","1769","2129","2532","4848","4574","345","412","2365","2368","4420","5378","530","3472","5657","2667","1383"));
		
		for (String offer : offers ) {
			for (String storeid : storeids) {
			ResultSet rs = session
					.execute("select * from limo_store_item.store_item_eligibilities where  offer_id = 0763493b-e8d4-427e-bf6a-ae42acb61b91 and store_number = '"+storeid+"' and mart_id= '0' and vertical_id = '2'");

			rs.forEach(r -> System.out.println(r));
			}
		}
			
		System.out.println("-------------------Done------------------------");
		
		session.close();
		cluster.close();
	}

}