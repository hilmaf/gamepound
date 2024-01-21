import React from 'react';
import styled from 'styled-components';


const StyledMainPageDiv = styled.div`
    width: 100vw;
    margin: auto;
    display: flex;
    flex-direction: column;
    color: var(--black-color);

    & > #mainimg {
        background-color: white;
        display: position;

        & > img {
            width: 100%;
            height: 300px;
            opacity: 1.0;
            object-fit: cover;
        }

    }

    & > #slogan {
        margin: auto;
        margin-top: 40px;
        margin-bottom: 20px;
        font-size: 30px;
    }

    & > button {
        width: 150px;
        height: 42px;
        background-color: var(--red-color);
        color: white;
        margin: auto;
        border-radius: 10px;
    }
`;

const MainPage = () => {
    return (
        <StyledMainPageDiv>
            <div id='mainimg'>
                <img src='http://127.0.0.1:8889/gamepound/resources/images/mainImg/mainimg.gif'></img>
            </div>
            <div id='slogan'>Pound for Indie Games</div>
            {/* <img src='http://127.0.0.1:8889/gamepound/resources/images/'></img> */}
            <button>프로젝트 둘러보기</button>
            
        </StyledMainPageDiv>
    );
};


export default MainPage;