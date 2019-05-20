import cv2
import numpy as np
# abre uma imagem
img = cv2.imread("/home/lgcaobianco/Downloads/background.jpg")
cv2.imshow("Imagem", img)
cv2.waitKey(0)
cv2.destroyAllWindows()


# opening a video
capture = cv2.VideoCapture("video.mp4")
while True:
    ret, frame = capture.read()
    cv2.imshow("Imagem", frame)
    if cv2.waitKey(1) & 0xFF == ord("q"):
        break
capture.release()
cv2.destroyAllWindows()

# split it into R G B channels and show only GREEN channel
# important to notice that function split() returns in the order B G R
capture = cv2.VideoCapture(0)
while True:
    ret, frame = capture.read()
    b, g, r = cv2.split(frame)
    cv2.imshow("Imagem", g)
    if cv2.waitKey(1) & 0xFF == ord("q"):
        break
capture.release()
cv2.destroyAllWindows()


# image from webcam converted to gray
capture = cv2.VideoCapture(0)
while True:
    ret, frame = capture.read()
    imagem = cv2.cvtColor(frame, cv2.COLOR_RGB2GRAY)
    cv2.imshow("Imagem", imagem)
    if cv2.waitKey(1) & 0xFF == ord("q"):
        break
capture.release()
cv2.destroyAllWindows()

# capture image from webcam, transform to HSV and show channels
capture = cv2.VideoCapture(0)
while True:
    ret, frame = capture.read()
    img = cv2.cvtColor(frame, cv2.COLOR_RGB2HSV)
    h, s, v = cv2.split(frame)
    cv2.imshow("hue", h)
    cv2.imshow("saturation", s)
    cv2.imshow("value", v)
    cv2.imshow("original", frame)
    if cv2.waitKey(1) & 0xFF == ord("q"):
        break
capture.release()
cv2.destroyAllWindows()

# capture image from webcam, set blue channel to 1 and show
capture = cv2.VideoCapture(0)
while True:
    ret, frame = capture.read()
    b, g, r = cv2.split(frame)
    try:
        g[:, :] = 1
        cv2.imshow("full red", cv2.merge((b, g, r)))
        if cv2.waitKey(1) & 0xFF == ord("q"):
            break
    except:
        print("error caught!!")
        capture.release()
        break
capture.release()
cv2.destroyAllWindows()
