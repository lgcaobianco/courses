import cv2
import numpy as np
from matplotlib import pyplot as plt


capture = cv2.VideoCapture(0)
image = []
while True:
    ret, frame = capture.read()
    cv2.imshow("Imagem", frame)
    if cv2.waitKey(1) & 0xFF == ord("q"):
        image = frame
        break
capture.release()
cv2.destroyAllWindows()
image_in_gray = cv2.cvtColor(image, cv2.COLOR_RGB2GRAY)
plt.hist(image.ravel(), 256, [0, 255])
plt.figure()
b, g, r = cv2.split(image)
plt.hist(b.ravel(), 256, [0, 255])
plt.figure()
plt.hist(g.ravel(), 256, [0, 255])
plt.figure()
plt.hist(r.ravel(), 256, [0, 255])
equalized = cv2.equalizeHist(image_in_gray)
cv2.imshow("original image", image_in_gray)
cv2.imshow("equalized image", equalized)
cv2.waitKey(0)
plt.hist(equalized.ravel(), 256, [0, 255])
plt.show()
cv2.destroyAllWindows()
