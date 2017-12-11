//
//  RNFlash.h
//  RNFlash
//
//  Created by Nicolas Clapiès on 2017-12-06.
//  Copyright © 2017 KrowbBeat. All rights reserved.
//

#import <Foundation/Foundation.h>

#if __has_include(<React/RCTAssert.h>)
#import <React/RCTBridgeModule.h>
#else
#import "RCTBridgeModule.h"
#endif

@interface RNFlash : NSObject <RCTBridgeModule>

@end
