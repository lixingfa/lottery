package com._3D.method;

import com._3D.number.Number1;

/**
 * 遗漏，距离上次出现隔了多远
 * 理想情况下，距离上次出现达到平均值时出现概率最高，
 * 超过均值会下降，超过一定限度后又提高
 * @author lixingfa
 *
 */
public class Yilou2 {	
	public void doit(int now,int[] num){
		int[][] g = new int[20][10];
		int max = 0;
		for (int i0j0 = 0; i0j0 < 100; i0j0++) {
			g[0][0] = i0j0;
			for (int i0j1 = 0; i0j1 < 100; i0j1++) {
				g[0][1] = i0j1;
				for (int i0j2 = 0; i0j2 < 100; i0j2++) {
					g[0][2] = i0j2;
					for (int i0j3 = 0; i0j3 < 100; i0j3++) {
						g[0][3] = i0j3;
						for (int i0j4 = 0; i0j4 < 100; i0j4++) {
							g[0][4] = i0j4;
							for (int i0j5 = 0; i0j5 < 100; i0j5++) {
								g[0][5] = i0j5;
								for (int i0j6 = 0; i0j6 < 100; i0j6++) {
									g[0][6] = i0j6;
									for (int i0j7 = 0; i0j7 < 100; i0j7++) {
										g[0][7] = i0j7;
										for (int i0j8 = 0; i0j8 < 100; i0j8++) {
											g[0][8] = i0j8;
											for (int i0j9 = 0; i0j9 < 100; i0j9++) {
												g[0][9] = i0j9;
												//
												for (int i1j0 = 0; i1j0 < 100; i1j0++) {
													g[1][0] = i1j0;
													for (int i1j1 = 0; i1j1 < 100; i1j1++) {
														g[1][1] = i1j1;
														for (int i1j2 = 0; i1j2 < 100; i1j2++) {
															g[1][2] = i1j2;
															for (int i1j3 = 0; i1j3 < 100; i1j3++) {
																g[1][3] = i1j3;
																for (int i1j4 = 0; i1j4 < 100; i1j4++) {
																	g[1][4] = i1j4;
																	for (int i1j5 = 0; i1j5 < 100; i1j5++) {
																		g[1][5] = i1j5;
																		for (int i1j6 = 0; i1j6 < 100; i1j6++) {
																			g[1][6] = i1j6;
																			for (int i1j7 = 0; i1j7 < 100; i1j7++) {
																				g[1][7] = i1j7;
																				for (int i1j8 = 0; i1j8 < 100; i1j8++) {
																					g[1][8] = i1j8;
																					for (int i1j9 = 0; i1j9 < 100; i1j9++) {
																						g[1][9] = i1j9;
																						//
																						for (int i2j0 = 0; i2j0 < 100; i2j0++) {
																							g[2][0] = i2j0;
																							for (int i2j1 = 0; i2j1 < 100; i2j1++) {
																								g[2][1] = i2j1;
																								for (int i2j2 = 0; i2j2 < 100; i2j2++) {
																									g[2][2] = i2j2;
																									for (int i2j3 = 0; i2j3 < 100; i2j3++) {
																										g[2][3] = i2j3;
																										for (int i2j4 = 0; i2j4 < 100; i2j4++) {
																											g[2][4] = i2j4;
																											for (int i2j5 = 0; i2j5 < 100; i2j5++) {
																												g[2][5] = i2j5;
																												for (int i2j6 = 0; i2j6 < 100; i2j6++) {
																													g[2][6] = i2j6;
																													for (int i2j7 = 0; i2j7 < 100; i2j7++) {
																														g[2][7] = i2j7;
																														for (int i2j8 = 0; i2j8 < 100; i2j8++) {
																															g[2][8] = i2j8;
																															for (int i2j9 = 0; i2j9 < 100; i2j9++) {
																																g[2][9] = i2j9;
																																//
																																for (int i3j0 = 0; i3j0 < 100; i3j0++) {
																																	g[3][0] = i3j0;
																																	for (int i3j1 = 0; i3j1 < 100; i3j1++) {
																																		g[3][1] = i3j1;
																																		for (int i3j2 = 0; i3j2 < 100; i3j2++) {
																																			g[3][2] = i3j2;
																																			for (int i3j3 = 0; i3j3 < 100; i3j3++) {
																																				g[3][3] = i3j3;
																																				for (int i3j4 = 0; i3j4 < 100; i3j4++) {
																																					g[3][4] = i3j4;
																																					for (int i3j5 = 0; i3j5 < 100; i3j5++) {
																																						g[3][5] = i3j5;
																																						for (int i3j6 = 0; i3j6 < 100; i3j6++) {
																																							g[3][6] = i3j6;
																																							for (int i3j7 = 0; i3j7 < 100; i3j7++) {
																																								g[3][7] = i3j7;
																																								for (int i3j8 = 0; i3j8 < 100; i3j8++) {
																																									g[3][8] = i3j8;
																																									for (int i3j9 = 0; i3j9 < 100; i3j9++) {
																																										g[3][9] = i3j9;
																																										//
																																										for (int i4j0 = 0; i4j0 < 100; i4j0++) {
																																											g[4][0] = i4j0;
																																											for (int i4j1 = 0; i4j1 < 100; i4j1++) {
																																												g[4][1] = i4j1;
																																												for (int i4j2 = 0; i4j2 < 100; i4j2++) {
																																													g[4][2] = i4j2;
																																													for (int i4j3 = 0; i4j3 < 100; i4j3++) {
																																														g[4][3] = i4j3;
																																														for (int i4j4 = 0; i4j4 < 100; i4j4++) {
																																															g[4][4] = i4j4;
																																															for (int i4j5 = 0; i4j5 < 100; i4j5++) {
																																																g[4][5] = i4j5;
																																																for (int i4j6 = 0; i4j6 < 100; i4j6++) {
																																																	g[4][6] = i4j6;
																																																	for (int i4j7 = 0; i4j7 < 100; i4j7++) {
																																																		g[4][7] = i4j7;
																																																		for (int i4j8 = 0; i4j8 < 100; i4j8++) {
																																																			g[4][8] = i4j8;
																																																			for (int i4j9 = 0; i4j9 < 100; i4j9++) {
																																																				g[4][9] = i4j9;
																																																				//
																																																				for (int i5j0 = 0; i5j0 < 100; i5j0++) {
																																																					g[5][0] = i5j0;
																																																					for (int i5j1 = 0; i5j1 < 100; i5j1++) {
																																																						g[5][1] = i5j1;
																																																						for (int i5j2 = 0; i5j2 < 100; i5j2++) {
																																																							g[5][2] = i5j2;
																																																							for (int i5j3 = 0; i5j3 < 100; i5j3++) {
																																																								g[5][3] = i5j3;
																																																								for (int i5j4 = 0; i5j4 < 100; i5j4++) {
																																																									g[5][4] = i5j4;
																																																									for (int i5j5 = 0; i5j5 < 100; i5j5++) {
																																																										g[5][5] = i5j5;
																																																										for (int i5j6 = 0; i5j6 < 100; i5j6++) {
																																																											g[5][6] = i5j6;
																																																											for (int i5j7 = 0; i5j7 < 100; i5j7++) {
																																																												g[5][7] = i5j7;
																																																												for (int i5j8 = 0; i5j8 < 100; i5j8++) {
																																																													g[5][8] = i5j8;
																																																													for (int i5j9 = 0; i5j9 < 100; i5j9++) {
																																																														g[5][9] = i5j9;
																																																														//
																																																														for (int i6j0 = 0; i6j0 < 100; i6j0++) {
																																																															g[6][0] = i6j0;
																																																															for (int i6j1 = 0; i6j1 < 100; i6j1++) {
																																																																g[6][1] = i6j1;
																																																																for (int i6j2 = 0; i6j2 < 100; i6j2++) {
																																																																	g[6][2] = i6j2;
																																																																	for (int i6j3 = 0; i6j3 < 100; i6j3++) {
																																																																		g[6][3] = i6j3;
																																																																		for (int i6j4 = 0; i6j4 < 100; i6j4++) {
																																																																			g[6][4] = i6j4;
																																																																			for (int i6j5 = 0; i6j5 < 100; i6j5++) {
																																																																				g[6][5] = i6j5;
																																																																				for (int i6j6 = 0; i6j6 < 100; i6j6++) {
																																																																					g[6][6] = i6j6;
																																																																					for (int i6j7 = 0; i6j7 < 100; i6j7++) {
																																																																						g[6][7] = i6j7;
																																																																						for (int i6j8 = 0; i6j8 < 100; i6j8++) {
																																																																							g[6][8] = i6j8;
																																																																							for (int i6j9 = 0; i6j9 < 100; i6j9++) {
																																																																								g[6][9] = i6j9;
																																																																								//
																																																																								for (int i7j0 = 0; i7j0 < 100; i7j0++) {
																																																																									g[7][0] = i7j0;
																																																																									for (int i7j1 = 0; i7j1 < 100; i7j1++) {
																																																																										g[7][1] = i7j1;
																																																																										for (int i7j2 = 0; i7j2 < 100; i7j2++) {
																																																																											g[7][2] = i7j2;
																																																																											for (int i7j3 = 0; i7j3 < 100; i7j3++) {
																																																																												g[7][3] = i7j3;
																																																																												for (int i7j4 = 0; i7j4 < 100; i7j4++) {
																																																																													g[7][4] = i7j4;
																																																																													for (int i7j5 = 0; i7j5 < 100; i7j5++) {
																																																																														g[7][5] = i7j5;
																																																																														for (int i7j6 = 0; i7j6 < 100; i7j6++) {
																																																																															g[7][6] = i7j6;
																																																																															for (int i7j7 = 0; i7j7 < 100; i7j7++) {
																																																																																g[7][7] = i7j7;
																																																																																for (int i7j8 = 0; i7j8 < 100; i7j8++) {
																																																																																	g[7][8] = i7j8;
																																																																																	for (int i7j9 = 0; i7j9 < 100; i7j9++) {
																																																																																		g[7][9] = i7j9;
																																																																																		//
																																																																																		for (int i8j0 = 0; i8j0 < 100; i8j0++) {
																																																																																			g[8][0] = i8j0;
																																																																																			for (int i8j1 = 0; i8j1 < 100; i8j1++) {
																																																																																				g[8][1] = i8j1;
																																																																																				for (int i8j2 = 0; i8j2 < 100; i8j2++) {
																																																																																					g[8][2] = i8j2;
																																																																																					for (int i8j3 = 0; i8j3 < 100; i8j3++) {
																																																																																						g[8][3] = i8j3;
																																																																																						for (int i8j4 = 0; i8j4 < 100; i8j4++) {
																																																																																							g[8][4] = i8j4;
																																																																																							for (int i8j5 = 0; i8j5 < 100; i8j5++) {
																																																																																								g[8][5] = i8j5;
																																																																																								for (int i8j6 = 0; i8j6 < 100; i8j6++) {
																																																																																									g[8][6] = i8j6;
																																																																																									for (int i8j7 = 0; i8j7 < 100; i8j7++) {
																																																																																										g[8][7] = i8j7;
																																																																																										for (int i8j8 = 0; i8j8 < 100; i8j8++) {
																																																																																											g[8][8] = i8j8;
																																																																																											for (int i8j9 = 0; i8j9 < 100; i8j9++) {
																																																																																												g[8][9] = i8j9;
																																																																																												//
																																																																																												for (int i9j0 = 0; i9j0 < 100; i9j0++) {
																																																																																													g[9][0] = i9j0;
																																																																																													for (int i9j1 = 0; i9j1 < 100; i9j1++) {
																																																																																														g[9][1] = i9j1;
																																																																																														for (int i9j2 = 0; i9j2 < 100; i9j2++) {
																																																																																															g[9][2] = i9j2;
																																																																																															for (int i9j3 = 0; i9j3 < 100; i9j3++) {
																																																																																																g[9][3] = i9j3;
																																																																																																for (int i9j4 = 0; i9j4 < 100; i9j4++) {
																																																																																																	g[9][4] = i9j4;
																																																																																																	for (int i9j5 = 0; i9j5 < 100; i9j5++) {
																																																																																																		g[9][5] = i9j5;
																																																																																																		for (int i9j6 = 0; i9j6 < 100; i9j6++) {
																																																																																																			g[9][6] = i9j6;
																																																																																																			for (int i9j7 = 0; i9j7 < 100; i9j7++) {
																																																																																																				g[9][7] = i9j7;
																																																																																																				for (int i9j8 = 0; i9j8 < 100; i9j8++) {
																																																																																																					g[9][8] = i9j8;
																																																																																																					for (int i9j9 = 0; i9j9 < 100; i9j9++) {
																																																																																																						g[9][9] = i9j9;																																																																																																		//
																																																																																																					for (int i10j0 = 0; i10j0 < 100; i10j0++) {
																																																																																																						g[10][0] = i10j0;
																																																																																																						for (int i10j1 = 0; i10j1 < 100; i10j1++) {
																																																																																																							g[10][1] = i10j1;
																																																																																																							for (int i10j2 = 0; i10j2 < 100; i10j2++) {
																																																																																																								g[10][2] = i10j2;
																																																																																																								for (int i10j3 = 0; i10j3 < 100; i10j3++) {
																																																																																																									g[10][3] = i10j3;
																																																																																																									for (int i10j4 = 0; i10j4 < 100; i10j4++) {
																																																																																																										g[10][4] = i10j4;
																																																																																																										for (int i10j5 = 0; i10j5 < 100; i10j5++) {
																																																																																																											g[10][5] = i10j5;
																																																																																																											for (int i10j6 = 0; i10j6 < 100; i10j6++) {
																																																																																																												g[10][6] = i10j6;
																																																																																																												for (int i10j7 = 0; i10j7 < 100; i10j7++) {
																																																																																																													g[10][7] = i10j7;
																																																																																																													for (int i10j8 = 0; i10j8 < 100; i10j8++) {
																																																																																																														g[10][8] = i10j8;
																																																																																																														for (int i10j9 = 0; i10j9 < 100; i10j9++) {
																																																																																																															g[10][9] = i10j9;
																																																																																																															//
																																																																																																															for (int i11j0 = 0; i11j0 < 100; i11j0++) {
																																																																																																																g[11][0] = i11j0;
																																																																																																																for (int i11j1 = 0; i11j1 < 100; i11j1++) {
																																																																																																																	g[11][1] = i11j1;
																																																																																																																	for (int i11j2 = 0; i11j2 < 100; i11j2++) {
																																																																																																																		g[11][2] = i11j2;
																																																																																																																		for (int i11j3 = 0; i11j3 < 100; i11j3++) {
																																																																																																																			g[11][3] = i11j3;
																																																																																																																			for (int i11j4 = 0; i11j4 < 100; i11j4++) {
																																																																																																																				g[11][4] = i11j4;
																																																																																																																				for (int i11j5 = 0; i11j5 < 100; i11j5++) {
																																																																																																																					g[11][5] = i11j5;
																																																																																																																					for (int i11j6 = 0; i11j6 < 100; i11j6++) {
																																																																																																																						g[11][6] = i11j6;
																																																																																																																						for (int i11j7 = 0; i11j7 < 100; i11j7++) {
																																																																																																																							g[11][7] = i11j7;
																																																																																																																							for (int i11j8 = 0; i11j8 < 100; i11j8++) {
																																																																																																																								g[11][8] = i11j8;
																																																																																																																								for (int i11j9 = 0; i11j9 < 100; i11j9++) {
																																																																																																																									g[11][9] = i11j9;
																																																																																																																									//
																																																																																																																									for (int i12j0 = 0; i12j0 < 100; i12j0++) {
																																																																																																																										g[12][0] = i12j0;
																																																																																																																										for (int i12j1 = 0; i12j1 < 100; i12j1++) {
																																																																																																																											g[12][1] = i12j1;
																																																																																																																											for (int i12j2 = 0; i12j2 < 100; i12j2++) {
																																																																																																																												g[12][2] = i12j2;
																																																																																																																												for (int i12j3 = 0; i12j3 < 100; i12j3++) {
																																																																																																																													g[12][3] = i12j3;
																																																																																																																													for (int i12j4 = 0; i12j4 < 100; i12j4++) {
																																																																																																																														g[12][4] = i12j4;
																																																																																																																														for (int i12j5 = 0; i12j5 < 100; i12j5++) {
																																																																																																																															g[12][5] = i12j5;
																																																																																																																															for (int i12j6 = 0; i12j6 < 100; i12j6++) {
																																																																																																																																g[12][6] = i12j6;
																																																																																																																																for (int i12j7 = 0; i12j7 < 100; i12j7++) {
																																																																																																																																	g[12][7] = i12j7;
																																																																																																																																	for (int i12j8 = 0; i12j8 < 100; i12j8++) {
																																																																																																																																		g[12][8] = i12j8;
																																																																																																																																		for (int i12j9 = 0; i12j9 < 100; i12j9++) {
																																																																																																																																			g[12][9] = i12j9;
																																																																																																																																			//
																																																																																																																																			for (int i13j0 = 0; i13j0 < 100; i13j0++) {
																																																																																																																																				g[13][0] = i13j0;
																																																																																																																																				for (int i13j1 = 0; i13j1 < 100; i13j1++) {
																																																																																																																																					g[13][1] = i13j1;
																																																																																																																																					for (int i13j2 = 0; i13j2 < 100; i13j2++) {
																																																																																																																																						g[13][2] = i13j2;
																																																																																																																																						for (int i13j3 = 0; i13j3 < 100; i13j3++) {
																																																																																																																																							g[13][3] = i13j3;
																																																																																																																																							for (int i13j4 = 0; i13j4 < 100; i13j4++) {
																																																																																																																																								g[13][4] = i13j4;
																																																																																																																																								for (int i13j5 = 0; i13j5 < 100; i13j5++) {
																																																																																																																																									g[13][5] = i13j5;
																																																																																																																																									for (int i13j6 = 0; i13j6 < 100; i13j6++) {
																																																																																																																																										g[13][6] = i13j6;
																																																																																																																																										for (int i13j7 = 0; i13j7 < 100; i13j7++) {
																																																																																																																																											g[13][7] = i13j7;
																																																																																																																																											for (int i13j8 = 0; i13j8 < 100; i13j8++) {
																																																																																																																																												g[13][8] = i13j8;
																																																																																																																																												for (int i13j9 = 0; i13j9 < 100; i13j9++) {
																																																																																																																																													g[13][9] = i13j9;
																																																																																																																																													//
																																																																																																																																													for (int i14j0 = 0; i14j0 < 100; i14j0++) {
																																																																																																																																														g[14][0] = i14j0;
																																																																																																																																														for (int i14j1 = 0; i14j1 < 100; i14j1++) {
																																																																																																																																															g[14][1] = i14j1;
																																																																																																																																															for (int i14j2 = 0; i14j2 < 100; i14j2++) {
																																																																																																																																																g[14][2] = i14j2;
																																																																																																																																																for (int i14j3 = 0; i14j3 < 100; i14j3++) {
																																																																																																																																																	g[14][3] = i14j3;
																																																																																																																																																	for (int i14j4 = 0; i14j4 < 100; i14j4++) {
																																																																																																																																																		g[14][4] = i14j4;
																																																																																																																																																		for (int i14j5 = 0; i14j5 < 100; i14j5++) {
																																																																																																																																																			g[14][5] = i14j5;
																																																																																																																																																			for (int i14j6 = 0; i14j6 < 100; i14j6++) {
																																																																																																																																																				g[14][6] = i14j6;
																																																																																																																																																				for (int i14j7 = 0; i14j7 < 100; i14j7++) {
																																																																																																																																																					g[14][7] = i14j7;
																																																																																																																																																					for (int i14j8 = 0; i14j8 < 100; i14j8++) {
																																																																																																																																																						g[14][8] = i14j8;
																																																																																																																																																						for (int i14j9 = 0; i14j9 < 100; i14j9++) {
																																																																																																																																																							g[14][9] = i14j9;
																																																																																																																																																							//
																																																																																																																																																							for (int i15j0 = 0; i15j0 < 100; i15j0++) {
																																																																																																																																																								g[15][0] = i15j0;
																																																																																																																																																								for (int i15j1 = 0; i15j1 < 100; i15j1++) {
																																																																																																																																																									g[15][1] = i15j1;
																																																																																																																																																									for (int i15j2 = 0; i15j2 < 100; i15j2++) {
																																																																																																																																																										g[15][2] = i15j2;
																																																																																																																																																										for (int i15j3 = 0; i15j3 < 100; i15j3++) {
																																																																																																																																																											g[15][3] = i15j3;
																																																																																																																																																											for (int i15j4 = 0; i15j4 < 100; i15j4++) {
																																																																																																																																																												g[15][4] = i15j4;
																																																																																																																																																												for (int i15j5 = 0; i15j5 < 100; i15j5++) {
																																																																																																																																																													g[15][5] = i15j5;
																																																																																																																																																													for (int i15j6 = 0; i15j6 < 100; i15j6++) {
																																																																																																																																																														g[15][6] = i15j6;
																																																																																																																																																														for (int i15j7 = 0; i15j7 < 100; i15j7++) {
																																																																																																																																																															g[15][7] = i15j7;
																																																																																																																																																															for (int i15j8 = 0; i15j8 < 100; i15j8++) {
																																																																																																																																																																g[15][8] = i15j8;
																																																																																																																																																																for (int i15j9 = 0; i15j9 < 100; i15j9++) {
																																																																																																																																																																	g[15][9] = i15j9;
																																																																																																																																																																	//
																																																																																																																																																																	for (int i16j0 = 0; i16j0 < 100; i16j0++) {
																																																																																																																																																																		g[16][0] = i16j0;
																																																																																																																																																																		for (int i16j1 = 0; i16j1 < 100; i16j1++) {
																																																																																																																																																																			g[16][1] = i16j1;
																																																																																																																																																																			for (int i16j2 = 0; i16j2 < 100; i16j2++) {
																																																																																																																																																																				g[16][2] = i16j2;
																																																																																																																																																																				for (int i16j3 = 0; i16j3 < 100; i16j3++) {
																																																																																																																																																																					g[16][3] = i16j3;
																																																																																																																																																																					for (int i16j4 = 0; i16j4 < 100; i16j4++) {
																																																																																																																																																																						g[16][4] = i16j4;
																																																																																																																																																																						for (int i16j5 = 0; i16j5 < 100; i16j5++) {
																																																																																																																																																																							g[16][5] = i16j5;
																																																																																																																																																																							for (int i16j6 = 0; i16j6 < 100; i16j6++) {
																																																																																																																																																																								g[16][6] = i16j6;
																																																																																																																																																																								for (int i16j7 = 0; i16j7 < 100; i16j7++) {
																																																																																																																																																																									g[16][7] = i16j7;
																																																																																																																																																																									for (int i16j8 = 0; i16j8 < 100; i16j8++) {
																																																																																																																																																																										g[16][8] = i16j8;
																																																																																																																																																																										for (int i16j9 = 0; i16j9 < 100; i16j9++) {
																																																																																																																																																																											g[16][9] = i16j9;
																																																																																																																																																																											//
																																																																																																																																																																											for (int i17j0 = 0; i17j0 < 100; i17j0++) {
																																																																																																																																																																												g[17][0] = i17j0;
																																																																																																																																																																												for (int i17j1 = 0; i17j1 < 100; i17j1++) {
																																																																																																																																																																													g[17][1] = i17j1;
																																																																																																																																																																													for (int i17j2 = 0; i17j2 < 100; i17j2++) {
																																																																																																																																																																														g[17][2] = i17j2;
																																																																																																																																																																														for (int i17j3 = 0; i17j3 < 100; i17j3++) {
																																																																																																																																																																															g[17][3] = i17j3;
																																																																																																																																																																															for (int i17j4 = 0; i17j4 < 100; i17j4++) {
																																																																																																																																																																																g[17][4] = i17j4;
																																																																																																																																																																																for (int i17j5 = 0; i17j5 < 100; i17j5++) {
																																																																																																																																																																																	g[17][5] = i17j5;
																																																																																																																																																																																	for (int i17j6 = 0; i17j6 < 100; i17j6++) {
																																																																																																																																																																																		g[17][6] = i17j6;
																																																																																																																																																																																		for (int i17j7 = 0; i17j7 < 100; i17j7++) {
																																																																																																																																																																																			g[17][7] = i17j7;
																																																																																																																																																																																			for (int i17j8 = 0; i17j8 < 100; i17j8++) {
																																																																																																																																																																																				g[17][8] = i17j8;
																																																																																																																																																																																				for (int i17j9 = 0; i17j9 < 100; i17j9++) {
																																																																																																																																																																																					g[17][9] = i17j9;
																																																																																																																																																																																					//
																																																																																																																																																																																					for (int i18j0 = 0; i18j0 < 100; i18j0++) {
																																																																																																																																																																																						g[18][0] = i18j0;
																																																																																																																																																																																						for (int i18j1 = 0; i18j1 < 100; i18j1++) {
																																																																																																																																																																																							g[18][1] = i18j1;
																																																																																																																																																																																							for (int i18j2 = 0; i18j2 < 100; i18j2++) {
																																																																																																																																																																																								g[18][2] = i18j2;
																																																																																																																																																																																								for (int i18j3 = 0; i18j3 < 100; i18j3++) {
																																																																																																																																																																																									g[18][3] = i18j3;
																																																																																																																																																																																									for (int i18j4 = 0; i18j4 < 100; i18j4++) {
																																																																																																																																																																																										g[18][4] = i18j4;
																																																																																																																																																																																										for (int i18j5 = 0; i18j5 < 100; i18j5++) {
																																																																																																																																																																																											g[18][5] = i18j5;
																																																																																																																																																																																											for (int i18j6 = 0; i18j6 < 100; i18j6++) {
																																																																																																																																																																																												g[18][6] = i18j6;
																																																																																																																																																																																												for (int i18j7 = 0; i18j7 < 100; i18j7++) {
																																																																																																																																																																																													g[18][7] = i18j7;
																																																																																																																																																																																													for (int i18j8 = 0; i18j8 < 100; i18j8++) {
																																																																																																																																																																																														g[18][8] = i18j8;
																																																																																																																																																																																														for (int i18j9 = 0; i18j9 < 100; i18j9++) {
																																																																																																																																																																																															g[18][9] = i18j9;
																																																																																																																																																																																															//
																																																																																																																																																																																															for (int i19j0 = 0; i19j0 < 100; i19j0++) {
																																																																																																																																																																																																g[19][0] = i19j0;
																																																																																																																																																																																																for (int i19j1 = 0; i19j1 < 100; i19j1++) {
																																																																																																																																																																																																	g[19][1] = i19j1;
																																																																																																																																																																																																	for (int i19j2 = 0; i19j2 < 100; i19j2++) {
																																																																																																																																																																																																		g[19][2] = i19j2;
																																																																																																																																																																																																		for (int i19j3 = 0; i19j3 < 100; i19j3++) {
																																																																																																																																																																																																			g[19][3] = i19j3;
																																																																																																																																																																																																			for (int i19j4 = 0; i19j4 < 100; i19j4++) {
																																																																																																																																																																																																				g[19][4] = i19j4;
																																																																																																																																																																																																				for (int i19j5 = 0; i19j5 < 100; i19j5++) {
																																																																																																																																																																																																					g[19][5] = i19j5;
																																																																																																																																																																																																					for (int i19j6 = 0; i19j6 < 100; i19j6++) {
																																																																																																																																																																																																						g[19][6] = i19j6;
																																																																																																																																																																																																						for (int i19j7 = 0; i19j7 < 100; i19j7++) {
																																																																																																																																																																																																							g[19][7] = i19j7;
																																																																																																																																																																																																							for (int i19j8 = 0; i19j8 < 100; i19j8++) {
																																																																																																																																																																																																								g[19][8] = i19j8;
																																																																																																																																																																																																								for (int i19j9 = 0; i19j9 < 5; i19j9++) {
																																																																																																																																																																																																									g[19][9] = i19j9;
																																																																																																																																																																																																									int t = totle(g, now, num);
																																																																																																																																																																																																									if (t > max) {
																																																																																																																																																																																																										max = t;
																																																																																																																																																																																																										System.out.println(t);
																																																																																																																																																																																																										for (int i = 0; i < g.length; i++) {
																																																																																																																																																																																																											for (int j = 0; j < g[i].length; j++) {
																																																																																																																																																																																																												System.out.print(g[i][j] + ",");
																																																																																																																																																																																																											}
																																																																																																																																																																																																											System.out.println();
																																																																																																																																																																																																										}
																																																																																																																																																																																																									}
																																																																																																																																																																																																									}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
																																																																																																																																												
		}
	}
	int[] num = Number1.num;
	
	/**
	 * 用遗传算法求每个取值上升、下降、上升三阶段的因数
	 * @param scope 取值范围
	 * @param now 当前期数
	 * @param chrs 取多少个染色体
	 * @param circle 稳定多少代后认为是最佳解
	 */
	public void doit(int scope,int now,int chrs,int circle,int check){
		Chromosome[] chroms = new Chromosome[chrs];
		
		//生成染色体，开始迭代
		for (int i = 0; i < chrs; i++) {
			chroms[i] = new Chromosome(scope, now,check);
		}
		boolean b = true;
		int same = 0;
		int maxTotal = 0;
		while (b) {
			//统计
			for (int i = 0; i < chroms.length; i++) {
				chroms[i].getTotal(now, scope);
			}
			//寻找最大
			Chromosome temp = chroms[0];
			for (int i = 0; i < chroms.length; i++) {
				if (chroms[i].total > temp.total) {
					temp = chroms[i];
				}
			}
			//交换、变异
			for (int i = 1; i < chroms.length; i++) {//第一个不发生改变
				chroms[i].variation(chroms[0]);//其他的以第一个为样板变异
			}
			//比较最大值
			if (temp.total > maxTotal) {
				maxTotal = temp.total;
				same = 0;
				System.out.println(maxTotal);
				for (int i = 0; i < temp.genes.length; i++) {
					System.out.print("[");
					for (int j = 0; j < temp.genes[i].length; j++) {
						System.out.print("," + temp.genes[i][j]);						
					}
					System.out.println("]");
				}
			}
			//得到结果
			if (maxTotal == circle) {
				b = false;
				System.out.println("当前共" + now + "期，中" + chroms[0].total);
				for (int i = 0; i < chroms[0].genes.length; i++) {
					System.out.print("[");
					for (int j = 0; j < chroms[0].genes[i].length; j++) {
						System.out.print("," + chroms[0].genes[i][j]);						
					}
					System.out.println("]");
				}
			}
		}
	}
	
	
	private class Chromosome{
		int total;
		int scope;//取值范围
		/**
		 * 热度h * g /检验范围check - a((与上次出现的距离l - k)/k)^2 + 1
		 * g,a,k 三个未知数
		 */
		int[][] genes;
		
		Chromosome(int scope,int now,int check){
			this.scope = scope;
			genes = new int[check][scope];
			
			for (int i = 0; i < genes.length; i++) {
				for (int j = 0; j < genes[i].length; j++) {
					genes[i][j] = (int)(Math.random() * 100);
				}
			}
			
		}
		
		private void getTotal(int now,int scope){
			total = totle(this.genes, now, num);			
		}
		
		/**
		 * 以某个染色体做样板进行变异
		 * @param chr
		 */
		private void variation(Chromosome chr){
			for (int i = 0; i < genes.length; i++) {
				for (int j = 0; j < genes[i].length; j++) {
					genes[i][j] = (int)(Math.random() * 100);
				}
			}
		}
	}
	
	private int totle(int[][] g,int now,int[] num){
		int totle = 0;
		for (int index = g.length; index <= now; index++) {
			//获取l
			int[] l = new int[g[0].length];
			boolean[] has = new boolean[g[0].length];//如果已经出现过，就不用计算遗漏
			for (int i = 0; i < l.length; i++) {
				int n = num[index - i];
				for (int j = 0; j < g[0].length; j++) {//遗漏
					if (n != j && !has[j]) {
						l[j]++;
					}else {
						has[j] = true;
					}
				}
			}
			//比较g[x][l]的大小
			int max = 0;
			int secend = 0;
			int flat = -1;
			int flatS = -1;
			for (int i = 0; i < g[0].length; i++) {
				if (g[l[i]][i] > max) {
					max = g[l[i]][i];
					flat = i;
				}
				if (g[l[i]][i] > secend && g[l[i]][i] < max ) {
					secend = g[l[i]][i];
					flatS = i;
				}
			}
			//看下次是否以最大的出现
			if (num[index + 1] == flat || num[index + 1] == flatS ) {
				totle++;
			}
		}		
		return totle;
	}
	
	public static void main(String[] args) {
//		new Yilou2().doit(1000,Number1.num);
		new Yilou2().doit(10, 1000, 1000, 500, 20);
	}
}
/*
 * 142
[,90,56,78,75,91,4,69,9,10,84]
[,18,97,97,50,61,29,99,42,24,9]
[,37,7,7,56,84,7,7,82,46,0]
[,1,88,94,50,65,24,35,84,57,21]
[,42,12,4,24,37,97,34,32,28,38]
[,83,54,18,56,28,9,72,99,78,71]
[,0,53,22,96,39,77,48,88,50,22]
[,9,16,15,89,50,13,22,74,36,96]
[,43,75,45,68,65,41,19,19,29,69]
[,83,29,17,53,36,56,79,42,54,79]
[,69,57,14,69,23,83,60,31,63,43]
[,29,78,43,37,29,79,41,30,19,41]
[,6,46,81,87,86,49,70,85,69,46]
[,27,16,99,2,11,84,10,8,37,54]
[,16,94,50,87,3,50,39,94,62,72]
[,19,23,32,32,8,82,76,8,21,41]
[,22,27,70,22,80,14,90,73,37,31]
[,37,24,56,84,11,21,47,38,22,9]
[,64,87,64,95,93,16,33,28,14,64]
[,77,76,95,43,22,50,72,2,15,62]
*/
