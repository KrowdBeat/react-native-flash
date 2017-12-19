//
//  RNFlash.m
//  RNFlash
//
//  Created by Nicolas Clapiès on 2017-12-06.
//  Copyright © 2017 KrowbBeat. All rights reserved.
//

#import <AVFoundation/AVFoundation.h>
#import "RNFlash.h"

@implementation RNFlash

RCT_EXPORT_MODULE()

@synthesize bridge = _bridge;

RCT_EXPORT_METHOD(hasFlash:(RCTResponseSenderBlock)successCallback errorCallbask:(RCTResponseSenderBlock)errorCallback)
{
    AVCaptureDevice *device = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
    if ([device hasTorch] && [device hasFlash]) {
        successCallback(@[]);
    } else {
        errorCallback(@[]);
    }
}

RCT_EXPORT_METHOD(turnOnFlash)
{
    [self doFlashWithLevel:1.0];
}

RCT_EXPORT_METHOD(turnOffFlash)
{
    AVCaptureDevice *device = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
    if ([device hasTorch] && [device hasFlash]){
        [device lockForConfiguration:nil];
        [device setTorchMode:AVCaptureTorchModeOff];
        [device unlockForConfiguration];
    }
}

- (void)doFlashWithLevel:(float)level
{
    AVCaptureDevice *device = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
    if ([device hasTorch] && [device hasFlash]){
        [device lockForConfiguration:nil];
        NSError *error = nil;
        float acceptedLevel = (level < AVCaptureMaxAvailableTorchLevel ? level : AVCaptureMaxAvailableTorchLevel);
        NSLog(@"FLash level: %f", acceptedLevel);
        [device setTorchModeOnWithLevel:acceptedLevel error:&error];
        [device unlockForConfiguration];
    }
}

- (void)doFakeFlashWithLevel:(float)level
{
    float acceptedLevel = (level < AVCaptureMaxAvailableTorchLevel ? level : AVCaptureMaxAvailableTorchLevel);
}

@end
